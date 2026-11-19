package ar.jornadas.data

import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AgendaRepository(
    private val api: ProgramaApi,
    private val dao: CarteleraDao,
    private val prefs: SharedPreferences
) {
    val programa = dao.observar()

    private val _hayEdicion = MutableStateFlow(prefs.getBoolean(CLAVE_EDICION, false))
    val hayEdicion: StateFlow<Boolean> = _hayEdicion.asStateFlow()

    suspend fun sincronizar() {
        val fichas = api.consultar().map {
            Charla(it.id, it.title, it.track, it.day, it.time, it.room, it.speaker, it.summary)
        }
        dao.reemplazarPrograma(fichas)
        prefs.edit().putBoolean(CLAVE_EDICION, true).apply()
        _hayEdicion.value = true
    }

    suspend fun cambiarFavorita(id: String) = dao.alternar(id)

    private companion object { const val CLAVE_EDICION = "hay_edicion" }
}
