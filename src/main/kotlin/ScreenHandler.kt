class ScreenHandler {
    private val archives = mutableListOf<Archive>()
    private var currentScreen: Screen = ArchivesScreen(archives)
    private var currentArchive: Int = -1
    fun app() {
        while (true) {
            val chosenAction = currentScreen.chooseAction()
            when (currentScreen) {
                is ArchivesScreen -> {
                    when (chosenAction.first) {
                        ScreenActions.CREATE -> {
                            val archiveName = currentScreen.elementAdditionMenu().first
                            archives.add(Archive(archiveName))
                        }

                        ScreenActions.SHOW -> {
                            val archiveNumber = chosenAction.second - 1
                            currentScreen = NotesScreen(archives[archiveNumber])
                            currentArchive = archiveNumber
                        }

                        ScreenActions.EXIT -> {
                            break
                        }
                    }
                }

                is NotesScreen -> {
                    when (chosenAction.first) {
                        ScreenActions.CREATE -> {
                            val notePair = currentScreen.elementAdditionMenu()
                            archives[currentArchive].notes.add(
                                Note(
                                    notePair.first,
                                    notePair.second
                                )
                            )
                        }

                        ScreenActions.SHOW -> {
                            currentScreen =
                                NoteViewingScreen(archives[currentArchive].notes[chosenAction.second - 1])
                        }

                        ScreenActions.EXIT -> {
                            currentScreen = ArchivesScreen(archives)
                        }
                    }
                }

                is NoteViewingScreen -> {
                    currentScreen = NotesScreen(archives[currentArchive])
                }
            }
        }
    }
}