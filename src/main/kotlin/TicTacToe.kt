const val CROSS = "X"
const val NULL = "0"
const val EMPTY = "*"
const val FIELD_SIZE = 3

fun main() {

    var currentPlayer = EMPTY

    val gameField = initGameField()

    var isVictory: Boolean
    var isDraw: Boolean

    printField(gameField)

    do {
        currentPlayer = changeSymbol(currentPlayer)

        printPlayerTurn(currentPlayer)

        makeTurn(currentPlayer, gameField)

        isVictory = checkVictory(gameField, currentPlayer)

        isDraw = checkDraw(gameField)

        printField(gameField)

    } while (!isVictory && !isDraw)

    if (isVictory) {
        println("Победил игрок - $currentPlayer")
    } else {
        println("Ничеечка!")
    }

}


fun checkDraw(gameField: MutableList<MutableList<String>>): Boolean {
    var isDraw = true
    for (i in gameField.indices) {
        for (j in gameField.indices) {
            if (gameField[i][j] == EMPTY) {
                isDraw = false
            }
        }
    }
    return isDraw
}

fun checkVictory(gameField: MutableList<MutableList<String>>, currentPlayer: String): Boolean {
    for (i in gameField.indices) {
        var rowWin = true
        var colWin = true
        for (j in gameField[i].indices) {
            if (gameField[i][j] != currentPlayer) {
                rowWin = false
            }

            if (gameField[j][i] != currentPlayer) {
                colWin = false
            }
        }
        if (rowWin || colWin) {
            return true
        }
    }

    var mainDiagonalWin = true
    var altDiagonalWin = true

    for (i in gameField.indices) {
        if (gameField[i][i] != currentPlayer) {
            mainDiagonalWin = false
        }

        if (gameField[i][FIELD_SIZE - i - 1] != currentPlayer) {
            altDiagonalWin = false
        }
    }

    return mainDiagonalWin || altDiagonalWin
}

fun makeTurn(currentPlayer: String, gameField: MutableList<MutableList<String>>) {
    val turnString = readln().split(" ")
    val x = turnString[0].toInt() - 1
    val y = turnString[1].toInt() - 1

    gameField[x][y] = currentPlayer
}

fun printPlayerTurn(currentPlayer: String) {
    println("Сейчас ходит $currentPlayer")
    println("Введите через пробел координаты \n сначала строка, затем столбец")
}

fun changeSymbol(currentPlayer: String): String {
    return if (currentPlayer != CROSS) {
        CROSS
    } else {
        NULL
    }
}

fun printField(gameField: MutableList<MutableList<String>>) {
    print("   |1|2|3|")
    println()
    for (i in gameField.indices) {
        print("|${i + 1}| ")
        for (j in gameField[i]) {
            print("$j ")
        }
        println()
    }
}

fun initGameField(): MutableList<MutableList<String>> {
    return mutableListOf(
        mutableListOf(EMPTY, EMPTY, EMPTY),
        mutableListOf(EMPTY, EMPTY, EMPTY),
        mutableListOf(EMPTY, EMPTY, EMPTY),
    )
}
