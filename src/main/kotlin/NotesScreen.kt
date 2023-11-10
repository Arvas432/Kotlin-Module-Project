import java.util.Scanner

class NotesScreen(val archive: Archive,override val items: List<out Element> = archive.notes): Screen() {
    override var menuItemCount = items.size + 1
    override fun printMenu(){
        println("Заметки в архиве ${archive.name}: ")
        println("0. Создать заметку")
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

    override fun elementAdditionMenu():Pair<String, String> {
        println("Введите название заметки:")
        val scanner = Scanner(System.`in`)
        var noteName = scanner.nextLine()
        while(noteName.isBlank()){
            println("Нельзя создать заметку с пустым названием, введите корректное название:")
            noteName = Scanner(System.`in`).nextLine()
        }
        println("Введите содержимое заметки \"$noteName\":")
        var noteContents = scanner.nextLine()
        while (noteContents.isBlank()){
            println("Нельзя создать заметку с пустым содержанием, введите корректное содержание:")
            noteContents = scanner.nextLine()
        }
        menuItemCount++
        return Pair(noteName, noteContents)
    }


}