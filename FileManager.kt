// Файл: FileManager.kt
package mypackage

import java.io.File

class FileManager(private val directory: String) : AbstractFileManager() {

    init {
        val dir = File(directory)
        if (!dir.exists()) {
            dir.mkdirs()
        }
    }

    override fun writeFile(fileName: String, content: String) {
        val file = File("$directory/$fileName")
        file.writeText(content)
    }

    override fun readFile(fileName: String): String {
        val file = File("$directory/$fileName")
        return if (file.exists()) {
            file.readText()
        } else {
            "Файл не найден"
        }
    }

    override fun deleteFile(fileName: String) {
        val file = File("$directory/$fileName")
        if (file.exists()) {
            file.delete()
        } else {
            println("Файл не найден")
        }
    }

    fun fileExists(fileName: String): Boolean {
        val file = File("$directory/$fileName")
        return file.exists()
    }
}
