import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.the

private val Project.libs get() = the<VersionCatalogsExtension>().named("libs")

fun Project.library(name: String) = libs.findLibrary(name).get()