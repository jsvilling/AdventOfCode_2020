package `06`

import java.util.*


/**
 * @author J. Villing
 */
class Puzzle_1 {

    fun solve(input: List<String>): Long {
        var count = 0L
        var entry = ""

        for (line: String in input) {
            if (line == "") {
                count += entry.chars().distinct().count()
                entry = ""
            } else {
                entry += line
            }
        }

        count += entry.chars().distinct().count()
        return count
    }

}


fun main() {
    val res = Puzzle_1().solve(Data.input)
    print(res)
}