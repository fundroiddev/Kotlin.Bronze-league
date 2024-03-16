package cycles

fun main() {
    println("Введите число,а код проверит, простое ли оно")
    val number = readln().toInt()
    if (number < 2) println("Число простое")
    var isSimple = true

    for (i in 2 until number) {
        if (number % i == 0) {
            isSimple = false
            break
        }
    }

    if (isSimple) {
        println("Число $number простое")
    } else {
        println("Число $number составное")
    }
}