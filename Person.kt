// Файл: Person.kt
package mypackage

class Person(private var name: String, private var age: Int) {
    // Геттеры и сеттеры
    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getAge(): Int {
        return age
    }

    fun setAge(age: Int) {
        this.age = age
    }
}
