class NoteViewingScreen(val note: Note, override var menuItemCount: Int = 0, override val items: List<out Element> = arrayListOf(note)): Screen() {
    override fun printMenu() {
        println("Текст заметки: ")
        println(note.content)
        println("0. Выход")
    }

    override fun chooseAction(): Pair<ScreenActions, Int> {
        printMenu()
        handleInput()
        return Pair(ScreenActions.EXIT, 0)
    }

    override fun elementAdditionMenu(): Pair<String, String> {
        return Pair("","")
    }
}