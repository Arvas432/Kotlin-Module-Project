import java.util.Scanner

abstract class Screen() {
    abstract var menuItemCount: Int
    abstract val items: List<out Element>
    abstract fun printMenu()
    abstract fun chooseAction(): Pair<ScreenActions,Int>
    abstract fun elementAdditionMenu(): Pair<String, String>
    fun handleInput(): Int{
        val scanner = Scanner(System.`in`)
        var userInput = scanner.nextLine().toIntOrNull()
        while((userInput == null) || ((userInput > menuItemCount) || (userInput < 0))){
            when{
                userInput == null ->{
                    println("Введите цифру: ")
                    printMenu()
                }
                ((userInput > menuItemCount) || (userInput < 0)) -> {
                    println("Такого пункта в меню нет, выберите еще раз: ")
                    printMenu()
                }
            }
            userInput = scanner.nextLine().toIntOrNull()
        }
        return userInput
    }
    fun printElements(){
        var counter = 1
        for (element in items) {

            println("$counter. ${element.name}")
            counter++
        }
        println("$counter. Выход")
        print("Выберите действие: ")
    }
}