package ar.jornadas.data

import androidx.room.*
import retrofit2.http.GET
import kotlinx.coroutines.flow.Flow

data class FichaRemota(val id: String, val title: String, val track: String, val day: Int,
    val time: String, val room: String, val speaker: String, val summary: String)

interface ProgramaApi {
    @GET("programa") suspend fun consultar(): List<FichaRemota>
}

@Entity(tableName = "charlas")
data class Charla(@PrimaryKey val id: String, val titulo: String, val tema: String, val dia: Int,
    val hora: String, val sala: String, val ponente: String, val resumen: String,
    val favorita: Boolean = false)

@Dao
abstract class CarteleraDao {
    @Query("SELECT * FROM charlas ORDER BY dia, hora, sala")
    abstract fun observar(): Flow<List<Charla>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun guardar(fichas: List<Charla>)

    @Query("UPDATE charlas SET favorita = NOT favorita WHERE id = :id")
    abstract suspend fun alternar(id: String)


    @Query("SELECT id FROM charlas WHERE favorita = 1")
    abstract suspend fun idsFavoritas(): List<String>

    @Query("DELETE FROM charlas WHERE id NOT IN (:vigentes)")
    abstract suspend fun borrarRetiradas(vigentes: List<String>)

    @Query("DELETE FROM charlas")
    abstract suspend fun borrarTodas()


    @Transaction
    open suspend fun reemplazarPrograma(nuevas: List<Charla>) {
        val marcadas = idsFavoritas().toSet()
        if (nuevas.isEmpty()) borrarTodas() else borrarRetiradas(nuevas.map { it.id })
        guardar(nuevas.map { it.copy(favorita = it.id in marcadas) })
    }
}

@Database(entities = [Charla::class], version = 1, exportSchema = false)
abstract class Archivo : RoomDatabase() {
    abstract fun cartelera(): CarteleraDao
}
