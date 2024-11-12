fun main() {
    try {
        println("Введите строку для сжатия:")
        val input = readLine() ?: throw IllegalArgumentException("Строка не может быть пустой.")

        if (input.isEmpty()) {
            throw IllegalArgumentException("Строка не может быть пустой.")
        }

        val output = compressString(input)
        println("Результат сжатия: $output") 
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    } catch (e: Exception) {
        println("Произошла непредвиденная ошибка: ${e.message}")
    }
}

fun compressString(input: String): String {
    val result = StringBuilder()
    var count = 1

    for (i in 1 until input.length) {
        if (input[i] == input[i - 1]) {
            count++
        } else {
            result.append(input[i - 1])
            if (count > 1) {
                result.append(count) 
            }
            count = 1 
        }
    }

    result.append(input[input.length - 1])
    if (count > 1) {
        result.append(count) 
    }

    return result.toString()
}
