import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the
import org.gradle.plugin.use.PluginDependency
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

class SharedKotlinLibraryConfig : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        val libs = the<LibrariesForLibs>()

        applyPlugins(libs)
        applyJavaConfig()
        applyKotlinConfig()
        applyDependencies()
    }

    private fun Project.applyPlugins(libs: LibrariesForLibs) = with(pluginManager) {
        //apply(JavaPlugin::class.java)
        alias(libs.plugins.java.library)
        alias(libs.plugins.jetbrains.kotlin.jvm)
    }

    private fun Project.applyJavaConfig() = extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    private fun Project.applyKotlinConfig() = extensions.configure<KotlinJvmProjectExtension> {
        jvmToolchain(17)
    }

    private fun Project.applyDependencies() = dependencies {
//        implementation(kotlin("stdlib"))
//        testImplementation(kotlin("test"))
    }

    private fun PluginManager.alias(provider: Provider<PluginDependency>) {
        apply(provider.get().pluginId)
    }

    private fun DependencyHandlerScope.implementation(dependencyNotation: Any) {
        add("implementation", dependencyNotation)
    }

    private fun DependencyHandlerScope.testImplementation(dependencyNotation: Any) {
        add("testImplementation", dependencyNotation)
    }
}