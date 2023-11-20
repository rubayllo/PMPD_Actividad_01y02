// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false

    // Plugin para poder enviar argumentos en nuestro gráfico de navegación
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    // Plugin para poder enviar argumentos seguros en nuestro gráfico de navegación
    id ("androidx.navigation.safeargs.kotlin") version "2.5.3" apply false
}