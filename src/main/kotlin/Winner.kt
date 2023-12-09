fun main() {
    // Ввод строки для шифрования
    println("Введите строку для шифрования: ")
    val inputString = readLine() ?: ""

    // Ввод кода для шифрования
    println("Введите код для шифрования: ")
    val enteredCode = readLine() ?: ""

    // Шифрование строки и вывод результата
    val encryptedString = encryptString(inputString, enteredCode)
    println("Зашифрованная строка: $encryptedString")
}

// Функция для шифрования строки методом Виженера
fun encryptString(input: String, code: String): String {
    // Алфавит для использования в шифровании
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    // Список для хранения зашифрованных символов
    val encryptedChars = mutableListOf<Char>()

    for (i in input.indices) {
        val inputChar = input[i]
        val codeChar = code[i % code.length]

        // Определение индекса символа в алфавите
        val begin = alphabet.indexOf(inputChar)
        // Определение смещения для шифрования
        val offset = alphabet.indexOf(codeChar)
        // Вычисление зашифрованного символа
        val encryptedChar = alphabet[(begin + offset) % alphabet.length]

        // Добавление зашифрованного символа в список
        encryptedChars.add(encryptedChar)
    }

    // Преобразование списка в строку и возврат результата
    return encryptedChars.joinToString("")
}
