package `03`

/**
 * @author J. Villing
 */
class Puzzle_2 {
    fun solve(input: Array<String>, slopes: Array<Pair<Int, Int>>): Int {
        var total = 1;
        for (slope: Pair<Int, Int> in slopes) {
            val treeCount: Int = solveWithSlope(slope.first, slope.second, input)
            total *= treeCount
        }
        return total
    }

    fun solveWithSlope(right: Int, down: Int, input: Array<String>): Int {
        var treeCount = 0
        for (i: Int in input.indices step down) {
            val row: String = input[i]
            val j: Int = (i/down * right) % row.length
            if (row[j] == Data.TREE) {
                treeCount++;
            }
        }
        return treeCount
    }
}

fun main() {
    val res: Int = Puzzle_2().solve(Data.input, Data.slopes)
    print(res)
}