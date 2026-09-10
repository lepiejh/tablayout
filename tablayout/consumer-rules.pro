# ============================================================================
# Consumer ProGuard/R8 rules for the tablayout library.
# These are packaged into the published AAR and applied AUTOMATICALLY to any
# app that depends on this library, so the app's own minification does not
# break the library.
# ============================================================================

# The library's public API must stay reachable and keep its names, otherwise
# apps (and the library's own layout XML, which stores fully-qualified custom
# view class names) would fail at runtime.
-keep public class com.androidkun.xtablayout.** { *; }
-keep public class com.bigkoo.pickerview.** { *; }
-keep public class com.codbking.widget.** { *; }
-keep public class com.contrarywind.** { *; }
-keep public class com.utils.** { *; }

# Custom views are instantiated by name from layout XML via reflection.
-keepclasseswithmembers class * extends android.view.View {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public <init>(android.content.Context, android.util.AttributeSet, int, int);
}
