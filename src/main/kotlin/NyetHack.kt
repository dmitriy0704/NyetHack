fun main() {
    narrate(
        ("A hero enters the town of Kronstadt. What is their name?"),
        { message -> "\u001b[33;1m$message\u001b[0m" }
    )
    val heroName = readLine()
    require(heroName != null && heroName.isNotEmpty()) {
        "The hero must have a name"
    }
    changeNarratorMood()
    narrate("$heroName, ${createTitle(heroName)}  heads to the town square")
}

private fun createTitle(heroName: String): String {
    return when {
        heroName.count { it.lowercase() in "aeiou" } > 4 -> "The Master of Vowel"
        else -> "The Renowned Hero"
    }
}