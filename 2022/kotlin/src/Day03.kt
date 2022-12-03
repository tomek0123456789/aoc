fun main() {
    val map = mutableMapOf<Char, Int>().apply {
        var index = 1
        ('a'..'z').forEach {
            this[it] = index
            index++
        }
        ('A'..'Z').forEach {
            this[it] = index
            index++
        }
    }

    fun part1(input: List<String>): Int {
        val pairs: MutableList<Pair<String, String>> = mutableListOf();
        input.forEach {
            val mid = it.length / 2
            pairs.add(Pair(it.substring(0, mid), it.substring(mid)))
        }
        var sum = 0
        for ((one, two) in pairs) {
            val firstSet = one.toSet()
            for (key in two.toSet()) {
                if (key in firstSet) {
                    sum += map[key]!!
                    break
                }
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var i = 0
        var sum = 0
        while (i < input.size) {
            val (one, two, three) = Triple(input[i].toSet(), input[i + 1].toSet(), input[i + 2].toSet())
            for (c in one) {
                if (c in two && c in three) {
                    sum += map[c]!!
                    break
                }
            }
            i += 3
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
