package ar.jornadas.lab;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lar/jornadas/lab/ServicioLocal;", "Lokhttp3/Interceptor;", "app", "Landroid/content/Context;", "(Landroid/content/Context;)V", "config", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "value", "", "demoraLarga", "getDemoraLarga", "()Z", "setDemoraLarga", "(Z)V", "disponible", "getDisponible", "setDisponible", "llamadas", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getLlamadas", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "revision", "getRevision", "()I", "setRevision", "(I)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_debug"})
public final class ServicioLocal implements okhttp3.Interceptor {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context app = null;
    private final android.content.SharedPreferences config = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> llamadas = null;
    
    public ServicioLocal(@org.jetbrains.annotations.NotNull()
    android.content.Context app) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> getLlamadas() {
        return null;
    }
    
    public final int getRevision() {
        return 0;
    }
    
    public final void setRevision(int value) {
    }
    
    public final boolean getDisponible() {
        return false;
    }
    
    public final void setDisponible(boolean value) {
    }
    
    public final boolean getDemoraLarga() {
        return false;
    }
    
    public final void setDemoraLarga(boolean value) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
}