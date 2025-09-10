/*
   |---------------------------|
   | Made by Audun and ChatGPT |
   |---------------------------|
 */

var gamesPlayed = 0L

fun main() {
    var playAgain = true

    while (playAgain) {
        print("\u001B[1m\u001B[36mWhat gamemode do you want? Easy, Medium, Hard, Extreme or Impossible: \u001B[0m")
        val gamemode = readlnOrNull()?.lowercase()

        val range: LongRange = when (gamemode) {
            "easy", "e" -> 1L..100L
            "medium", "m" -> 1L..250L
            "hard", "h" -> 1L..1000L
            "extreme" -> 1L..100_000L
            "impossible" -> 1L..Long.MAX_VALUE // future-proof
            else -> {
                println("Invalid choice, defaulting to Easy.")
                1L..100L
            }
        }

        val number = range.random()
        var attempts = 0L
        var guessed = false

        println("\u001B[1m\u001B[33mI picked a number between ${range.first} and ${range.last}. Can you guess it?\u001B[0m")

        while (!guessed) {
            print("\u001B[1m\u001B[36mYour guess: \u001B[0m")
            val guess = readlnOrNull()?.toLongOrNull() // <-- changed to Long

            if (guess == null) {
                println("\u001B[1m\u001B[31mPlease enter a valid number!\u001B[0m")
                continue
            }

            if (guess !in range) {
                println("\u001B[1m\u001B[31mNumber must be between ${range.first} and ${range.last}!\u001B[0m")
                continue
            }

            attempts++

            if (attempts % 10 == 0L) {
                println("\u001B[32mYou have used $attempts attempts now\u001B[0m")
            }

            when {
                guess < number -> println("\u001B[1m\u001B[34mToo low!\u001B[0m")
                guess > number -> println("\u001B[1m\u001B[35mToo high!\u001B[0m")
                else -> {
                    println("\u001B[1m\u001B[32mCorrect! The number was $number. You guessed it in $attempts tries.\u001B[0m")
                    guessed = true
                    gamesPlayed++
                }
            }
        }

        print("\u001B[1m\u001B[33mDo you want to play again? (y/n): \u001B[0m")
        val response = readlnOrNull()?.lowercase()
        playAgain = response == "y"
    }

    val gameText = if (gamesPlayed == 1L) "game" else "games"
    println("\u001B[1m\u001B[32mYou've played $gamesPlayed $gameText! Thanks for playing! Goodbye!\u001B[0m")
}
