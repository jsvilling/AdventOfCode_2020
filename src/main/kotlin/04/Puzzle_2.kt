package `04`

/**
 * @author J. Villing
 */
class Puzzle_2 {

    fun solve(input: List<String>): Int {
        var validCount = 0;
        var i = 0;
        while (i < input.size) {
            var entry = ""
            do {
                val line = input[i++]
                entry = "$entry-$line"
            } while(line != "" && i < input.size)
            if (isValidEntry(entry)) {
                validCount++
            }
        }
        return validCount
    }

    private fun isValidEntry(entry: String): Boolean {
        return entry.split("-", " ").stream()
                .map { it.split(":") }
            .filter {it.size > 1}
                .filter {
                    Data.rules[it[0]]?.invoke(it[1]) ?: false
                }
                .count() == Data.props.size.toLong()
    }

}


fun main() {
    val res = Puzzle_2().solve(Data.input)
    print(res)
}