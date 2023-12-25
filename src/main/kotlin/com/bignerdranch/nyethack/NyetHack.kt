package com.bignerdranch.nyethack

val player = Player(
    "Jason"
)

fun main() {
    //changeNarratorMood()
    val mortality = if (player.isImmortal) "an immortal" else "a mortal"
    narrate("${player.name} of ${player.hometown}, ${player.title},heads to the town square")
    narrate("${player.name}, $mortality, has ${player.healthPoints} health points")
    visitTavern()
    player.castFireBall()
}

private fun promptHeroName(): String {
    narrate(
        ("A hero enters the town of Kronstadt. What is their name?"),
        // Выводит message желтым цветом
        { message -> "\u001b[33;1m$message\u001b[0m" }
    )
    /*val input = readLine()
    require(heroName != null && heroName.isNotEmpty()) {
        "The hero must have a name"
    }
    return input*/
    println("Madrigal")
    return "Madrigal"
}