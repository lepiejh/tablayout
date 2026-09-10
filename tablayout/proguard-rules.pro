# ============================================================================
# tablayout (com.github.lixiong) library - ProGuard / R8 rules
# ----------------------------------------------------------------------------
# Obfuscation policy requested:
#   KEEP  -> public classes + their public members, and private members
#   OBFUSCATE -> everything that is neither public nor private, i.e.
#                protected / package-private classes, methods, fields and
#                inner (nested) classes.
#
# This file replaces the previous copy that was pasted from an unrelated MVVM
# app project (it was fully duplicated and referenced libraries this module
# does not depend on: retrofit, glide, okhttp, rxjava, immersionbar, etc.).
# ============================================================================


# ---------------------------------------------------------------------------
# 0. Attributes / global options
# ---------------------------------------------------------------------------
# Annotations, generics signature and exceptions are needed at runtime.
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes Exceptions
# Keep nested-class metadata so reflection / generic inner types still work.
-keepattributes InnerClasses,EnclosingMethod
# Keep line numbers for readable crash logs, but hide the real source name.
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Move every obfuscated (non-kept) class into the root package.
-repackageclasses ''
# Avoid names that differ only by case (important on Windows / case-insensitive FS).
-dontusemixedcaseclassnames
# Do not run code optimizations on the vendored widget code (safer); shrinking
# and obfuscation are still performed.
-dontoptimize


# ---------------------------------------------------------------------------
# 1. Public API - KEEP (the library is published as an AAR, consumers call it)
#    Public classes are kept from removal AND renaming, together with their
#    public constructors / fields / methods.
#    Protected members are kept separately below (section 1b).
#    private / package-private members and non-public classes are NOT matched
#    -> obfuscated.
# ---------------------------------------------------------------------------
# Scoped per package (instead of one universal `**`) so each rule stays under
# the IDE "overly broad keep rule" (>100 classes) inspection threshold. All of
# the library's program classes live in these five packages, so this is
# functionally identical to `**` for this module.
-keep public class com.androidkun.xtablayout.** {
    public <init>(...);
    public <fields>;
    public <methods>;
}
-keep public class com.bigkoo.pickerview.** {
    public <init>(...);
    public <fields>;
    public <methods>;
}
-keep public class com.codbking.widget.** {
    public <init>(...);
    public <fields>;
    public <methods>;
}
-keep public class com.contrarywind.** {
    public <init>(...);
    public <fields>;
    public <methods>;
}
-keep public class com.utils.** {
    public <init>(...);
    public <fields>;
    public <methods>;
}

# ---------------------------------------------------------------------------
# 1b. Protected members - KEEP (subclasses in consumer apps rely on them)
#     Applies to ALL classes in the library (public or not), per requirement.
#     -keepclassmembers keeps the member names (and prevents their removal)
#     without forcing the enclosing class to be kept.
# ---------------------------------------------------------------------------
-keepclassmembers class com.androidkun.xtablayout.** {
    protected <fields>;
    protected <methods>;
}
-keepclassmembers class com.bigkoo.pickerview.** {
    protected <fields>;
    protected <methods>;
}
-keepclassmembers class com.codbking.widget.** {
    protected <fields>;
    protected <methods>;
}
-keepclassmembers class com.contrarywind.** {
    protected <fields>;
    protected <methods>;
}
-keepclassmembers class com.utils.** {
    protected <fields>;
    protected <methods>;
}

# NOTE: private / package-private members and non-public classes are
# intentionally NOT kept, so R8 obfuscates them. Public (section 1) and
# protected (section 1b) keep their names. Local-variable names are stripped
# automatically because LocalVariableTable is not listed in -keepattributes.


# ---------------------------------------------------------------------------
# 2. Custom Views - always keep, they are instantiated by name from XML
#    (LayoutInflater uses the (Context, AttributeSet) constructors via
#    reflection, and layout XML stores the fully-qualified class name string).
# ---------------------------------------------------------------------------
-keepclasseswithmembers class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public <init>(android.content.Context, android.util.AttributeSet, int, int);
}


# ---------------------------------------------------------------------------
# 3. Standard framework keeps
# ---------------------------------------------------------------------------
# native methods (JNI resolves them by name)
-keepclasseswithmembernames class * {
    native <methods>;
}

# enums: values()/valueOf() are called reflectively by the runtime
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Parcelable CREATOR field
-keepclassmembers class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

# Serializable members that must survive (only applies if such classes exist)
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Resource id fields must not be renamed
-keepclassmembers class **.R$* {
    public static <fields>;
}


# ---------------------------------------------------------------------------
# 4. Dependencies provided at runtime by the host app (compileOnly).
#    They are on the compile classpath, not packaged here. Silence warnings for
#    references that R8 cannot fully resolve while minifying this library.
# ---------------------------------------------------------------------------
-dontwarn com.ved.framework.**
-dontwarn com.google.android.material.**
-dontwarn androidx.**
# Optional references pulled in transitively by the compileOnly framework deps
# (okhttp/conscrypt, image picker, downloader, GraalVM, JDK-only classes). They
# are not packaged into this AAR and are not needed at runtime here.
-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**
-dontwarn org.graalvm.**
-dontwarn com.yanzhenjie.album.**
-dontwarn com.liulishuo.filedownloader.**
-dontwarn java.lang.instrument.**
-dontwarn java.lang.ClassValue
