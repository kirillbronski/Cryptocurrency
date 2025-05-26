package com.kbcoding.android.templates.script

import java.net.URI
import java.net.URL
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

interface TemplateFileSystem : AutoCloseable {

    fun getTemplates(): List<Path>

    companion object {
        fun create(codeLocation: URL): TemplateFileSystem {
            return if (codeLocation.file.endsWith(".jar")) {
                // execution from Terminal
                JarTemplateFileSystem(codeLocation)
            } else {
                // execution from Android Studio
                IdeBuildTemplateFileSystem(codeLocation)
            }
        }
    }
}

private class JarTemplateFileSystem(
    private val codeLocation: URL,
) : TemplateFileSystem {

    private val fileSystem by lazy {
        val path = Paths.get(codeLocation.path)
        val fileUri = path.toUri()
        val jarUri = URI.create("jar:$fileUri")
        FileSystems.newFileSystem(jarUri, emptyMap<String, String>())
    }

    override fun getTemplates(): List<Path> {
        return Files.list(fileSystem.getPath("/templates")).toList()
    }

    override fun close() {
        fileSystem.close()
    }
}

private class IdeBuildTemplateFileSystem(
    private val codeLocation: URL,
) : TemplateFileSystem {
    override fun getTemplates(): List<Path> {
        val path = Path.of(codeLocation.toURI())
            .parent.parent.parent
            .resolve("resources/main/templates")
        return Files.list(path).toList()
    }

    override fun close() = Unit
}
