import java.io.File
import kotlin.random.Random
import kotlin.random.nextInt

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER`s Folly"
private val firstNames = setOf("Alex", "Mordoc", "Sophie", "Tariq")
private val lastNames =
    setOf("Ironfoot", "Fernsworth", "Baggins", "Downstrider")
private val menuData = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")
    .map { it.split(",") }

private val menuItems = menuData.map { (_, name, _) -> name }
private val menuItemPrices =
    menuData.associate { (_, name, price) -> name to price.toDouble() }
private val menuItemTypes =
    menuData.associate { (type, name, _) -> name to type }

fun visitTavern() {
    narrate("$heroName enters $TAVERN_NAME")
    narrate("There are several items for sale:")
    println(menuItems.joinToString())



    val patrons: MutableSet<String> = mutableSetOf()
    val patronGold = mutableMapOf(
        TAVERN_MASTER to 86.00,
        heroName to 4.50
    )
    while (patrons.size < 5) {
        val patronName = "${firstNames.random()} ${lastNames.random()}"
        patrons += patronName
        patronGold += patronName to 6.0
    }
    narrate("$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())

    val favoriteItems = patrons.map { getFavoriteMenuItems(it)}
    println("Favorite items: $favoriteItems")

    repeat(3) {
        placeOrder(patrons.random(), menuItems.random(), patronGold)
    }
    displayPatronBalances(patronGold)
}

private fun getFavoriteMenuItems(patron: String): List<String>{
    return when(patron) {
        "Alex Ironfoot" -> menuItems.filter {menuItem ->
            menuItemTypes[menuItem]?.contains("desert") == true
        }
        else -> menuItems.shuffled().take(Random.nextInt(1..2))
    }
}

private fun placeOrder(
    patronName: String,
    menuItemName: String,
    patronGold: MutableMap<String, Double>
) {
    val itemPrice = menuItemPrices.getValue(menuItemName)
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    if (itemPrice <= patronGold.getOrDefault(patronName, 0.0)) {
        val action = when (menuItemTypes[menuItemName]) {
            "shandy", "elixir" -> "pour"
            "meal" -> "serves"
            else -> "hands"
        }
        narrate("$TAVERN_MASTER $action $patronName a $menuItemName")
        narrate("$patronName pays $TAVERN_MASTER $itemPrice gold")
        patronGold[patronName] = patronGold.getValue(patronName) - itemPrice
        patronGold[TAVERN_MASTER] =
            patronGold.getValue(TAVERN_MASTER) + itemPrice
    } else {
        narrate(
            "$TAVERN_MASTER says, " +
                    " \"You need more coin for a $menuItemName\" "
        )
    }
}

private fun displayPatronBalances(patronGold: Map<String, Double>) {
    narrate("$heroName intuitively knows how much money patron has")
    patronGold.forEach { (patron, balance) ->
        narrate("$patron has ${"%.2f".format(balance)} gold")
    }
}