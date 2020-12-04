package `04`


/**
 * @author J. Villing
 */
class Puzzle_1 {

    fun solve(input: List<String>): Int {
        var validCount = 0;
        var i = 0;
        while (i < input.size) {
            var entry = ""
            do {
                val line = input[i++]
                entry += line
            } while(line != "" && i < input.size)
            if (isValid(entry)) {
                validCount++
            }
        }
        return validCount
    }

    fun isValid(entry: String): Boolean {
        return Data.props.stream().allMatch { entry.contains(it) }
    }
}


fun main() {
    val res = Puzzle_1().solve(Data.input)
    print(res)
}