package `06`

/**
 * @author J. Villing
 */
class Puzzle_2 {

    fun solve(input: List<String>): Int {
        var entry = ""
        var groupSize = 0

        val ml: MutableList<Pair<String, Int>> = mutableListOf()
        for (line: String in input) {
            if (line == "") {
                ml.add(Pair(entry, groupSize))
                groupSize = 0
                entry = ""
            } else {
                entry += line
                groupSize++
            }
        }
        ml.add(Pair(entry, groupSize))


        return ml.stream()
            .mapToInt { getGroupCount(it.first, it.second) }
            .sum()
    }

    fun getGroupCount(entry: String, groupSize: Int): Int {
        var count = 0
        for (c: Char in entry.toCharArray().distinct()) {
            if (entry.filter { c == it }.count() == groupSize) {
                count ++
            }
        }
        return count
    }
}

fun main() {
    val res = Puzzle_2().solve(Data.input)
    print(res)
}