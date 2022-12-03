fun main() {
    fun part1(input: List<String>): Int {
        val scoreMap = mapOf("A" to mapOf("X" to 3, "Y" to 6, "Z" to 0),
                        "B" to mapOf("X" to 0, "Y" to 3, "Z" to 6),
                        "C" to mapOf("X" to 6, "Y" to 0, "Z" to 3))
        val choiceMap = mapOf("X" to 1, "Y" to 2, "Z" to 3)
        /*
                       X Y Z
                rock A 1 0 2
               paper B 2 1 0
            scissors C 0 2 1
        */
        var result = 0
        for (s in input) {
            val line = s.split(" ")
            result += scoreMap[line[0]]!![line[1]]!!
            result += choiceMap[line[1]]!!
        }
        return result
    }

    fun part2(input: List<String>): Int {
        val scoreMap = mapOf("A" to mapOf("X" to 3, "Y" to 4, "Z" to 8),
            "B" to mapOf("X" to 1, "Y" to 5, "Z" to 9),
            "C" to mapOf("X" to 2, "Y" to 6, "Z" to 7))
        var result = 0
        for (s in input) {
            val line = s.split(" ")
            result += scoreMap[line[0]]!![line[1]]!!
        }
        return result
    }
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
