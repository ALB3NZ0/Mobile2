// Файл: Main.kt
package mypackage

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val fileManager = FileManager("files")

    println("Добро пожаловать!")
    println("Выберите роль:")
    println("1. Администратор")
    println("2. Пользователь")

    when (scanner.nextInt()) {
        1 -> {
            println("Вы выбрали роль: Администратор")
            val admin = User("admin", "adminpassword", "admin")

            // Создаем список людей
            val people = mutableListOf<Person>()

            // Добавляем людей
            repeat(10) {
                println("Введите имя человека №${it + 1}:")
                val name = scanner.next()
                println("Введите возраст человека №${it + 1}:")
                val age = scanner.nextInt()
                people.add(Person(name, age))
            }

            println("Список людей успешно создан.")

            // Дальнейшие действия с данными списка людей
            while (true) {
                println("Выберите действие:")
                println("1. Записать в файл")
                println("2. Прочитать файл")
                println("3. Удалить файл")
                println("4. Выход")

                when (scanner.nextInt()) {
                    1 -> {
                        // Запись в файл
                    }
                    2 -> {
                        println("Введите имя файла для чтения:")
                        val fileName = scanner.next()
                        val filePath = "files/$fileName"

                        if (fileManager.fileExists(fileName)) {
                            val content = fileManager.readFile(fileName)
                            println("Содержимое файла $fileName:")
                            println(content)
                        } else {
                            println("Файл $fileName не найден.")
                        }
                    }
                    3 -> {
                        println("Введите имя файла для удаления:")
                        val fileName = scanner.next()
                        fileManager.deleteFile(fileName)
                        println("Файл удален.")
                    }
                    4 -> {
                        println("Выход из программы.")
                        return
                    }
                    else -> {
                        println("Некорректный ввод.")
                    }
                }
            }
        }
        2 -> {
            println("Вы выбрали роль: Пользователь")
            val user = User("user", "userpassword", "user")

            while (true) {
                println("Выберите действие:")
                println("1. Войти в систему")
                println("2. Выход")

                when (scanner.nextInt()) {
                    1 -> {
                        println("Введите имя пользователя:")
                        val username = scanner.next()
                        println("Введите пароль:")
                        val password = scanner.next()
                        if (user.login(username, password)) {
                            println("Вы успешно вошли в систему.")
                            while (true) {
                                println("Выберите действие:")
                                println("1. Выполнить действие 1")
                                println("2. Выполнить действие 2")
                                println("3. Выйти из системы")

                                when (scanner.nextInt()) {
                                    1 -> user.performAction("action1")
                                    2 -> user.performAction("action2")
                                    3 -> {
                                        user.logout()
                                        println("Выход из системы.")
                                        break
                                    }
                                    else -> println("Некорректный ввод.")
                                }
                            }
                        } else {
                            println("Неправильные учетные данные.")
                        }
                    }
                    2 -> {
                        println("Выход из программы.")
                        return
                    }
                    else -> {
                        println("Некорректный ввод.")
                    }
                }
            }
        }
        else -> {
            println("Некорректный ввод.")
        }
    }
}
