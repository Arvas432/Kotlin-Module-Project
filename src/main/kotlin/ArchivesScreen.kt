import java.util.Scanner

class ArchivesScreen( override val items: List<out Element> = arrayListOf<Archive>()) : Screen() {

    override var menuItemCount: Int = items.size+1
    override fun printMenu(){
        println("Список архивов: ")
        println("0. Создать архив")
        printElements()
    }
    override fun chooseAction(): Pair<ScreenActions, Int> {
        printMenu()
        return when (val userInput = handleInput()) {
            0 -> Pair(ScreenActions.CREATE, 0)
            menuItemCount -> Pair(ScreenActions.EXIT, menuItemCount)
            else -> Pair(ScreenActions.SHOW, userInput)
        }
    }

    override fun elementAdditionMenu(): Pair<String,String> {
        println("Введите название архива:")
        var addedArchiveName = Scanner(System.`in`).nextLine()
        while (addedArchiveName.isBlank()) {
            println("Нельзя создать архив с пустым названием, введите корректное название:")
            addedArchiveName = Scanner(System.`in`).nextLine()
        }
        println("архив ${addedArchiveName} создан и добавлен")
        menuItemCount++
        return Pair(addedArchiveName,"")
    }
}