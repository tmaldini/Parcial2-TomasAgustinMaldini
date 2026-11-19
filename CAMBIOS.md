# Cambios realizados

La base de datos **sigue en la versión 1**: no se cambió la tabla, así que los usuarios que ya tenían la app conservan sus charlas y favoritas. No se usa `fallbackToDestructiveMigration`.

## 41 · Programa sin señal
- **Problema:** ante una falla, `Catalogo` ocultaba la grilla y mostraba solo el error, aunque hubiera datos guardados. Tampoco se podía distinguir "nunca descargué" de "descargué una v4 vacía".
- **Solución:** `AgendaRepository` guarda en SharedPreferences (`hay_edicion`) que hubo al menos una descarga exitosa y lo expone como `hayEdicion`. `Catalogo` distingue tres casos:
  - Falla **sin** edición previa → mensaje + **Reintentar**.
  - Edición válida vacía (v4) → «Sin charlas programadas» (también al reabrir sin señal).
  - Falla **con** edición previa → lista, detalle y favoritas desde Room + «Sin conexión: usando datos guardados».

## 42 · Agenda personal
- **Problema:** `guardar` con `REPLACE` reemplazaba cada fila con `favorita = false` (se perdían las marcas) y nunca borraba las charlas retiradas.
- **Solución:** `CarteleraDao.reemplazarPrograma` con `@Transaction`:
  1. lee las favoritas **en el momento en que llega la respuesta** (así se respeta una marca puesta o quitada durante la petición),
  2. borra las charlas que ya no están en el programa (la 11 en v3 desaparece del catálogo y de Mi agenda),
  3. guarda las nuevas conservando la marca solo de las vigentes.
  Una charla que se retira y vuelve entra sin marcar, porque su fila se borró. Al ser una transacción, si algo falla no queda nada a medias.

## 43 · Volver al punto de lectura
- **Problema:** el tema estaba en un `remember` dentro de `Catalogo`; se perdía al abrir una ficha (el composable sale de pantalla) y al girar. El día estaba en el ViewModel y se perdía si Android mataba el proceso.
- **Solución:** día y tema se guardan en el `SavedStateHandle` del ViewModel (`elegirDia`, `elegirTema`). Sobreviven a la ficha, al giro y a la muerte del proceso; una tarea nueva arranca sin filtros. La ficha abierta ya usaba `rememberSaveable`.

## 44 · Control de descargas
- **Problema:** se descargaba en `MainActivity.onStart` (cada vez que se volvía a la app o se rotaba) y además en un `LaunchedEffect` de `Catalogo` (cada vez que se volvía de una ficha o de otra pestaña). Varios toques lanzaban varias peticiones.
- **Solución:** se quitaron las dos llamadas. La carga automática se hace en el `init` del ViewModel, una vez por proceso (bandera en `Servicios`). `recargar()` sale si ya hay una petición en curso (`if (cargando) return`) y el botón se deshabilita mientras carga. Los filtros siguen editables.

## Refactorizaciones
- **Servicios único por proceso:** antes cada ViewModel creaba su propia base Room y su Retrofit. Ahora `Servicios.de(context)` usa `applicationContext` y una sola instancia.
- **Tapa y vidrio:** `aviso` y `cargando` pasaron a `MutableStateFlow` privados expuestos con `asStateFlow()`; la pantalla ya no puede modificarlos. Los filtros se cambian con funciones del ViewModel.
- **Errores:** `recargar` atrapa cualquier error de red o de datos, pero relanza la `CancellationException`.
- **Compilación:** se agregó OkHttp 4.12.0 (Retrofit 2.11 traía OkHttp 3 y no compilaba `toMediaType`).

## Pruebas manuales
1. **44:** abrir la app → Mesa muestra 1 petición. Rotar, entrar a una ficha, cambiar de pestaña y volver: sigue en 1. Activar la demora larga, tocar Actualizar dos veces: suma 1.
2. **42:** marcar la 11 en v1 → pasar a v2 y Actualizar: la 11 sigue marcada, con «Compose en producción avanzada» y «Sala Puerto». Pasar a v3: la 11 desaparece del catálogo y de Mi agenda, aparece la 90 y las demás marcas siguen. Volver a v2: la 11 regresa sin marcar.
3. **42 (durante la petición):** con demora larga, tocar Actualizar y, mientras carga, marcar una charla vigente: al llegar la respuesta sigue marcada.
4. **41:** con datos guardados, apagar el servicio y Actualizar: se ve la lista con «usando datos guardados». `pm clear` + arranque sin señal: aparece Reintentar. v4 exitosa: «Sin charlas programadas»; reabrir sin señal: lo mismo.
5. **43:** Día 2 + Datos, abrir «Cachés para viajeros», volver y rotar: 2 resultados de Datos. Con la ficha abierta, Inicio, `adb shell am kill ar.jornadas` y volver desde Recientes: vuelve la ficha y, al salir, los dos filtros.
