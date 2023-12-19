# NyetHack

//listOf - неизменяемый список
//    val patrons: List<String> = listOf("Eli", "Mordoc", "Sophie")
//mutableListOf - изменяемый список

//    for(patron in patrons){
//        println("Good evening, $patron ")
//    }

//    patrons.forEach { patron ->
//        println("Good evening, $patron")
//    }

//    patrons.forEachIndexed { index, patron ->
//        when (index) {
//            2 -> {
//                println("Good evening, $patron, you ${index + 1} in line")
//            }
//        }
//    }


// для mutableListOf:
//    narrate("Eli leaves the tavern")
//    patrons.remove("Ele")
//    narrate("Alex enters the tavern")
//    patrons.add("Alex")
//    println(patrons)
//    patrons.add(0, "VIP")
//    println(patrons)
//    patrons[0] = "Alexis"
//    println(patrons)
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
//}

