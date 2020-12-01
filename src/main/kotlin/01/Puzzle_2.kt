package `01`


/**
 * @author J. Villing
 */
class Puzzle_2 {

    /**
     * Horribly inefficient at O(n³).
     * If there is time I'll find a more efficient solution.
     */
    fun solve(t: Int, input: IntArray): Int {
        for (i: Int in input.indices) {
            for (j: Int in input.indices) {
                for (k: Int in input.indices) {
                    if (input[i] + input[j] + input[k] == t) {
                        return input[i] * input[j] * input[k]
                    }
                }
            }
        }
        return -1
    }
}

fun main(args: Array<String>) {
    val r: Int = Puzzle_2().solve(Data.x, Data.input)
    print(r)
}