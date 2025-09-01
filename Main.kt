fun main() {
    println("\u001B[1m\u001B[33mHello there :D What is your name?\u001B[0m")
    val name = readlnOrNull()


    println("\u001B[1m\u001B[32mCool name, $name!\u001B[0m")

    println("\u001B[33m\u001B[1mNow what is your age, $name?\u001B[0m")
    val age = readlnOrNull()?.toIntOrNull() ?: return println("\u001B[31m\u001B[1mNot a number!\u001B[0m")

    val responseListOld = listOf("Wow, you drive a car!", "Take a beer, my guy!", "Are you married?")
    val responseListYoung = listOf("Do you still have a bedtime?", "Here is some soda!", "Chocolate milk is the best!")

    if (age < 18){
        println("\u001B[1m\u001B[32m${responseListYoung.random()}\u001B[0m")
    } else {
        println("\u001B[32m\u001B[1m${responseListOld.random()}\u001B[0m")
    }
}