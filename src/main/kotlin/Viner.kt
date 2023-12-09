fun main() {
    println("Введите строку для шифрования: ")
    val inputString = readLine() ?: ""

    println("Введите код для шифрования: ")
    val enteredCode = readLine() ?: ""

    val encryptedString = encryptString(inputString, enteredCode)

    println("Зашифрованная строка: $encryptedString")
}

fun encryptString(input: String, code: String): String {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    val encryptedChars = mutableListOf<Char>()

    for (i in input.indices) {
        val inputChar = input[i]
        val codeChar = code[i % code.length]

        val begin = alphabet.indexOf(inputChar)
        val offset = alphabet.indexOf(codeChar)
        val encryptedChar = alphabet[(begin + offset) % 33]

        encryptedChars.add(encryptedChar)
    }

    return encryptedChars.joinToString("")
}
