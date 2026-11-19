package ar.jornadas;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"Lar/jornadas/Servicios;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "agenda", "Lar/jornadas/data/AgendaRepository;", "getAgenda", "()Lar/jornadas/data/AgendaRepository;", "api", "Lar/jornadas/data/ProgramaApi;", "kotlin.jvm.PlatformType", "archivo", "Lar/jornadas/data/Archivo;", "cargaInicialHecha", "", "getCargaInicialHecha", "()Z", "setCargaInicialHecha", "(Z)V", "mesa", "Lar/jornadas/lab/ServicioLocal;", "getMesa", "()Lar/jornadas/lab/ServicioLocal;", "Companion", "app_debug"})
public final class Servicios {
    @org.jetbrains.annotations.NotNull()
    private final ar.jornadas.lab.ServicioLocal mesa = null;
    @org.jetbrains.annotations.NotNull()
    private final ar.jornadas.data.Archivo archivo = null;
    private final ar.jornadas.data.ProgramaApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final ar.jornadas.data.AgendaRepository agenda = null;
    private boolean cargaInicialHecha = false;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile ar.jornadas.Servicios instancia;
    @org.jetbrains.annotations.NotNull()
    public static final ar.jornadas.Servicios.Companion Companion = null;
    
    private Servicios(android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ar.jornadas.lab.ServicioLocal getMesa() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ar.jornadas.data.AgendaRepository getAgenda() {
        return null;
    }
    
    public final boolean getCargaInicialHecha() {
        return false;
    }
    
    public final void setCargaInicialHecha(boolean p0) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lar/jornadas/Servicios$Companion;", "", "()V", "instancia", "Lar/jornadas/Servicios;", "de", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ar.jornadas.Servicios de(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}