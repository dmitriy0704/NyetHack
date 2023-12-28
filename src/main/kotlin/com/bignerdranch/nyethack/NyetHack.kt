package com.bignerdranch.nyethack

lateinit var player: Player

fun main() {
    narrate("Welcome to NyetHack!")
    val playerName = promptHeroName()
    player = Player(playerName)
    //changeNarratorMood()
    player.prophesize()
    var currentRoom: Room = Tavern()
    val mortality = if (player.isImmortal) "an immortal" else "a mortal"
    narrate("${player.name} of ${player.hometown}, ${player.title}, is in ${currentRoom.description()}")
    narrate("${player.name}, $mortality, has ${player.healthPoints} health points")
    currentRoom.enterRoom()
    player.castFireBall()
    player.prophesize()
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