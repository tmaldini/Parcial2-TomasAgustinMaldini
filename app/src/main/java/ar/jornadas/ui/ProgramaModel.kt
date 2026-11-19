package ar.jornadas.ui

import android.app.Application
import androidx.lifecycle.*
import ar.jornadas.Servicios
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ProgramaModel(app: Application, private val estado: SavedStateHandle) : AndroidViewModel(app) {
    private val servicios = Servicios.de(app)
    val mesa = servicios.mesa
    private val repo = servicios.agenda
    val charlas = repo.programa.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    val hayEdicion = repo.hayEdicion

    val dia: StateFlow<Int> = estado.getStateFlow(CLAVE_DIA, 0)
    val tema: StateFlow<String> = estado.getStateFlow(CLAVE_TEMA, "Todos")
    fun elegirDia(d: Int) { estado[CLAVE_DIA] = d }
    fun elegirTema(t: String) { estado[CLAVE_TEMA] = t }

    private val _aviso = MutableStateFlow("")
    val aviso: StateFlow<String> = _aviso.asStateFlow()
    private val _cargando = MutableStateFlow(false)
    val cargando: StateFlow<Boolean> = _cargando.asStateFlow()

    init {

        if (!servicios.cargaInicialHecha) {
            servicios.cargaInicialHecha = true
            recargar()
        }
    }

    fun recargar() {
        if (_cargando.value) return
        _cargando.value = true
        _aviso.value = ""
        viewModelScope.launch {
            try {
                repo.sincronizar()
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _aviso.value = "No se pudo consultar el programa"
            } finally {
                _cargando.value = false
            }
        }
    }

    fun marcar(id: String) { viewModelScope.launch { repo.cambiarFavorita(id) } }

    private companion object {
        const val CLAVE_DIA = "dia"
        const val CLAVE_TEMA = "tema"
    }
}
