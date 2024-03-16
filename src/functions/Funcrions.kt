package functions

fun main() {
    println("Введите число,а код проверит, простое ли оно")
    val number = readln().toInt()
    val isSimple = isSimple(number)

    if (isSimple) {
        println("Число $number простое")
    } else {
        println("Число $number составное")
    }
}

private fun isSimple(number: Int): Boolean {
    if (number < 2) {
        return true
    }

    for (i in 2 until number) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}