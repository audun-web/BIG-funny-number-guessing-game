/*
   |---------------------------|
   | Made by Audun and chatgpt |
   |---------------------------|
 */


var gamesplayed = 0

fun main() {
    var playAgain = true

    while (playAgain) {
        val number = (1..100).random()
        var attempts = 0
        var guessed = false

        // start message
        println("\u001B[1m\u001B[33mI picked a number between 1 and 100. Can you guess it?\u001B[0m")
        /*
        println("dev hahaha $number")
        */

        while (!guessed) {
            print("\u001B[1m\u001B[36mYour guess: \u001B[0m")
            val guess = readlnOrNull()?.toIntOrNull()
            Runtime.getRuntime().exec(arrayOf("afplay", "/System/Library/Sounds/Glass.aiff"))

            // if the number is over the interger limite
            if (guess == null) {
                println("\u001B[1m\u001B[31mPlease enter a valid number!\u001B[0m")
                continue
            }

            // if user(s) guesses anything over the the max number or bellow
            if (guess !in 1..100) {
                println("\u001B[1m\u001B[31mNumber must be between 1 and 100!\u001B[0m")
                continue
            }

            attempts++

            // every time user(s) used any 10, 20 , 30... etc
            if (attempts % 10 == 0) {
                println("\u001B[32mYou have used $attempts attempts now")
            }

            // number logic
            when {
                guess < number -> println("\u001B[1m\u001B[34mToo low!\u001B[0m")
                guess > number -> println("\u001B[1m\u001B[35mToo high!\u001B[0m")
                else -> {
                    println("\u001B[1m\u001B[32mCorrect! The number was $number. You guessed it in $attempts tries.\u001B[0m")
                    guessed = true
                    gamesplayed += 1
                }
            }
        }

        // Ask if the user wants to play again
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
