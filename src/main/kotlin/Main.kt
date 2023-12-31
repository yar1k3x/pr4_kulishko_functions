import kotlin.random.Random

fun main() {
    println("Добро пожаловать в игру Камень-Ножницы-Бумага!")
    println("Выберите свой ход: 1 - Камень, 2 - Ножницы, 3 - Бумага")

    // Получение выбора игрока с консоли
    val playerChoice = readLine()?.toIntOrNull()

    // Проверка корректности ввода игрока
    if (playerChoice != null && playerChoice in 1..3) {
        // Получение случайного выбора компьютера
        val computerChoice = Random.nextInt(1, 4)

        // Отображение выборов игрока и компьютера
        displayChoices(playerChoice, computerChoice)

        // Определение победителя и вывод результата
        val result = determineWinner(playerChoice, computerChoice)
        println(result)
    } else {
        println("Некорректный ввод. Пожалуйста, выберите число от 1 до 3.")
    }
}

// Отображение выборов игрока и компьютера
fun displayChoices(player: Int, computer: Int) {
    println("Ваш выбор: ${translateChoice(player)}")
    println("Выбор компьютера: ${translateChoice(computer)}")
}

// Преобразование числового выбора в строковый
fun translateChoice(choice: Int): String {
    return when (choice) {
        1 -> "Камень"
        2 -> "Ножницы"
        3 -> "Бумага"
        else -> "Неизвестный выбор"
    }
}

// Определение победителя
fun determineWinner(player: Int, computer: Int): String {
    return when {
        player == computer -> "Ничья! Переиграйте еще раз."
        (player == 1 && computer == 2) || (player == 2 && computer == 3) || (player == 3 && computer == 1) ->
            "Вы победили! Поздравляю!"
        else -> "Вы проиграли. Попробуйте еще раз."
    }
}
