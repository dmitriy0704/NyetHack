package com.bignerdranch.nyethack

class Village(val name: String, val homeTown: String){
    val personality: String
    val race = "Dwarf"
    var age = 50
        private set
    init {
        println("initializing village")
        personality = "Outgoing"
    }
    constructor(name: String) : this(name, "Bavaria"){
        age = 99
    }
}