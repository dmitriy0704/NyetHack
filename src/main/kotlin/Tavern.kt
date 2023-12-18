import java.util.*

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER`s Folly"

fun visitTavern() {
    narrate("$heroName enters $TAVERN_NAME")

    val patrons: List<String> = listOf("Eli", "Mordoc", "Sophie")
    val eliMessage = if (patrons.contains("Eli")) {
        "$TAVERN_MASTER says: Eli`s in the back playing cards"
    } else {
        "$TAVERN_MASTER says: Eli isn`t here"
    }
    println(eliMessage)

    val othersMessage = if (patrons.containsAll(listOf("Mordoc", "Sophie"))) {
        "$TAVERN_MASTER says: Sophie and Mordoc are seated by the stew kettle"
    } else {
        "$TAVERN_MASTER says: Sophie and Mordoc aren't with each other right now"
    }
    println(othersMessage)

//    println(patrons[0])
//    println(
//        patrons
//            .map { it.uppercase(Locale.getDefault()) }
//            .filter { it.length < 4 }
//    )
//    println(patrons.first())
//    println(patrons.last())
//
//    patrons.getOrNull(4) ?: "Unknown Patron"
//    patrons.getOrElse(4) { "Unknown Patron" }
}