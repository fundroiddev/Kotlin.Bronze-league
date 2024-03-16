package collections

fun main() {
    val intArray = arrayOf(5, 7, 1, 0, 3, 2)
    val sortedArray = bubbleSort(intArray)
    for (i in sortedArray) {
        print("$i ")
    }
}

fun bubbleSort(intArray: Array<Int>): Array<Int> {
    for (i in 1..intArray.size - 2) {
        for (j in 0 .. intArray.size - 2) {
            if (intArray[j] > intArray[j + 1]) {
                swapElements(intArray, j)
            }
        }
    }
    return intArray
}

fun swapElements(intArray: Array<Int>, i: Int) {
    val tempElement = intArray[i]
    intArray[i] = intArray[i+1]
    intArray[i+1] = tempElement
}
