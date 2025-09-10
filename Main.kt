/*
   |---------------------------|
   | Made by Audun and chatgpt |
   |---------------------------|
 */

var gamesplayed = 0

fun main() {
    var playAgain = true

    while (playAgain) {
        print("\u001B[1m\u001B[36mWhat gamemode do you want? easy, medium, hard or extreme.: \u001B[0m")
        val gamemode = readlnOrNull()?.lowercase()

        val range = when (gamemode) {
            "easy", "e" -> 1..100
            "medium", "m" -> 1..250
            "hard", "h" -> 1..1000
            "extreme" -> 1..100000
            "imposable" -> 1..1000000000
            else -> {
                println("Invalid choice, defaulting to Easy.")
                1..100
            }
        }

        val number = range.random()
        var attempts = 0
        var guessed = false

        println("\u001B[1m\u001B[33mI picked a number between ${range.first} and ${range.last}. Can you guess it?\u001B[0m")

        /* Dev */
        // println(number)


        while (!guessed) {
            print("\u001B[1m\u001B[36mYour guess: \u001B[0m")
            val guess = readlnOrNull()?.toIntOrNull()
            Runtime.getRuntime().exec(arrayOf("afplay", "/System/Library/Sounds/Glass.aiff"))

            if (guess == null) {
                println("\u001B[1m\u001B[31mPlease enter a valid number!\u001B[0m")
                continue
            }

            if (guess !in range) {
                println("\u001B[1m\u001B[31mNumber must be between ${range.first} and ${range.last}!\u001B[0m")
                continue
            }

            attempts++

            if (attempts % 10 == 0) {
                println("\u001B[32mYou have used $attempts attempts now")
            }


            when {
                guess < number -> println("\u001B[1m\u001B[34mToo low!\u001B[0m")
                guess > number -> println("\u001B[1m\u001B[35mToo high!\u001B[0m")
                else -> {
                    println("\u001B[1m\u001B[32mCorrect! The number was $number. You guessed it in $attempts tries.\u001B[0m")
                    guessed = true
                    gamesplayed++
                }
            }
        }

        print("\u001B[1m\u001B[33mDo you want to play again? (y/n): \u001B[0m")
        val response = readlnOrNull()?.lowercase()
        playAgain = response == "y"
    }

    if (gamesplayed < 2) {
        println("\u001B[1m\u001B[32mYou´ve played $gamesplayed game! Thanks for playing! Goodbye!\u001B[0m")
    } else {
        println("\u001B[1m\u001B[32mYou´ve played $gamesplayed games! Thanks for playing! Goodbye!\u001B[0m")
    }
}
