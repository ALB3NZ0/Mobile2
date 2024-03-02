// Файл: User.kt
package mypackage

class User(private var username: String, private var password: String, private var role: String) {
    // Свойства
    private var isLoggedIn: Boolean = false

    // Методы
    fun login(username: String, password: String): Boolean {
        if (this.username == username && this.password == password) {
            isLoggedIn = true
            return true
        }
        return false
    }

    fun logout() {
        isLoggedIn = false
    }

    fun performAction(action: String) {
        if (!isLoggedIn) {
            println("Пользователь не авторизован")
            return
        }

        when(role) {
            "admin" -> {
                when(action) {
                    "action1" -> println("Выполняется действие 1 для администратора")
                    "action2" -> println("Выполняется действие 2 для администратора")
                    else -> println("Неизвестное действие")
                }
            }
            "user" -> {
                when(action) {
                    "action1" -> println("Выполняется действие 1 для пользователя")
                    "action2" -> println("Выполняется действие 2 для пользователя")
                    else -> println("Неизвестное действие")
                }
            }
            else -> println("Неизвестная роль")
        }
    }

    // Геттеры и сеттеры
    fun getUsername(): String {
        return username
    }

    fun setUsername(username: String) {
        this.username = username
    }

    fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getRole(): String {
        return role
    }

    fun setRole(role: String) {
        this.role = role
    }
}
