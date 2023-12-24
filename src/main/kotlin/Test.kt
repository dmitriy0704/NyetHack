fun main() {
    val numbers: List<String> = listOf("1.0", "2.0", "3.0")
    val numberToDouble: List<Double> = numbers.map { it.toDouble() }
    println(numberToDouble)
}