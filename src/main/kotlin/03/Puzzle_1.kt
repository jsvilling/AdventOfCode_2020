package `03`

import java.util.*

/**
 * @author J. Villing
 */
class Puzzle_1 {

    fun solve(input: Array<String>): Int {
        var treeCount = 0;
        for (i: Int in input.indices) {
            val row: String = input[i]
            val j: Int = (i * 3) % row.length
            if (row[j] == Data.TREE) {
                treeCount++;
            }
        }
        return treeCount;
    }
}

fun main() {
    val res: Int = Puzzle_1().solve(Data.input)
    print(res)
}