fun main() {
    fun part1(input: List<String>): Int {
        var max = 0
        var current = 0
        for (calories in input) {
            if (calories == "") {
                if (max < current) {
                    max = current
                }
                current = 0
            } else {
                current += calories.toInt()
            }
        }
        return max
    }

    fun part2(input: List<String>): Int {
        val maxSet = setOf(-1, -2, -3).toMutableSet()
        var current = 0
        for (calories in input) {
            if (calories == "") {
                if (maxSet.min() < current) {
                    maxSet.remove(maxSet.min())
                    maxSet.add(current)
                }
                current = 0
            } else {
                current += calories.toInt()
            }
        }
        return maxSet.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
//    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
