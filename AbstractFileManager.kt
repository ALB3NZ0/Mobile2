// Файл: AbstractFileManager.kt
package mypackage

import java.io.File

abstract class AbstractFileManager {
    abstract fun writeFile(fileName: String, content: String)
    abstract fun readFile(fileName: String): String
    abstract fun deleteFile(fileName: String)
}
