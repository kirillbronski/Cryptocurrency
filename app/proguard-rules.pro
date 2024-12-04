# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

## Keep the @Serializable annotation
#-keepattributes *Annotation*
#
## Keep the generated serializer classes
#-keep,includedescriptorclasses class **$$serializer { *; }
#
## Keep the Companion objects (if any)
#-keep,includedescriptorclasses class **$Companion { *; }
#
## Keep classes annotated with @Serializable and their members
#-keepclassmembers class * {
#    @kotlinx.serialization.Serializable *;
#}
#
## Optional: Keep enums (if you're serializing enums)
#-keepclassmembers enum * {
#    *;
#}
#
## Исключения для сериализуемых объектов
#-keep @kotlinx.serialization.Serializable class com.kbcoding.cryptocurrency.core.presentation.RouteCoins { *; }
#-keep @kotlinx.serialization.Serializable class com.kbcoding.cryptocurrency.core.presentation.RouteFavorite { *; }
#-keep @kotlinx.serialization.Serializable class com.kbcoding.cryptocurrency.core.presentation.RouteCoinDetail { *; }
#
## Для сериализации kotlinx
#-keep class kotlinx.serialization.** { *; }
#-keep @kotlinx.serialization.Serializable class **
#-keepclasseswithmembers class ** {
#    @kotlinx.serialization.Serializable *;
#}

# Сохранить для всех параметризованных классов
-keep class * implements java.lang.reflect.ParameterizedType { *; }