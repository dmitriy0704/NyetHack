package com.bignerdranch.nyethack

lateinit var player: Player

fun main() {
    narrate("Welcome to NyetHack!")
    val playerName = promptHeroName()
    player = Player(playerName)
    //changeNarratorMood()
    Game.play()
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

object Game {

    private var currentRoom: Room = TownSquare()
    private var currentPosition = Coordinate(0, 0)

    init {
        narrate("Welcome, adventurer!")
        val mortality = if (player.isImmortal) "an immortal" else "a mortal"
        narrate("${player.name}, $mortality, has ${player.healthPoints} health points")
    }

    fun play() {
        while (true) {
            narrate("${player.name} of ${player.hometown}, ${player.title}, is in ${currentRoom.description()}")
            currentRoom.enterRoom()
            print("> Enter you command: ")
            GameInput(readLine()).processCommand()
        }
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when (command.lowercase()) {
            else -> narrate("I`m not sure what you`re trying to do")
        }
    }
}