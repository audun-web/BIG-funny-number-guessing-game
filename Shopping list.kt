var shoppingList = mutableListOf("")

fun main() {
    println("\u001B[1m\u001b[32mShopping List Manager!\u001B[0m")


    while (true) {
        println("\u001b[1mChose an Option!\u001b[0m")
        println("1. Check your Shopping List!")
        println("2. Add an item!")
        println("3. Remove an item!")
        println("4. Quit!")

        val input = readlnOrNull()?.toIntOrNull() ?: continue

        when (input) {
            1 -> {
                println("This is your shoppinglist")
                println(shoppingList)
            }
            2 -> {
                while (true) {2
                    println("Which item do you want to add? (Type 'done' to finish adding items)")
                    val itemAdd = readlnOrNull()?.trim()

                    if (itemAdd.equals("done", ignoreCase = true)) {
                        println("Finished adding items.")
                        break
                    }

                    if (!itemAdd.isNullOrBlank()) {
                        shoppingList.add(itemAdd)
                        println("\u001B[32m'$itemAdd' has been added to your list.\u001B[0m")
                    } else {
                        println("\u001B[31mInvalid input. Please enter an item or 'done'.\u001B[0m")
                    }
                }
            }
            3 -> {
                println("What item do you want to remove: ")
                val itemRemove = readlnOrNull().toString()

                if (itemRemove.lowercase() !in shoppingList){
                    println("This item is not in your list!")
                } else {
                    println("\nThe item $itemRemove was removed from your list!")
                    shoppingList.remove(itemRemove)
                }
            }
            4 -> {
                println("Do you wish to exit?")
                val quitInput = readlnOrNull().toString()

                if (quitInput.lowercase() != "yes"){

                } else {
                    println("Thanks for using Audun Shoppinglist!")
                    break
                }
            }
        }


    }

}
