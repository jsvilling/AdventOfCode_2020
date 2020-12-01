package `01`

import java.util.*

/**
 * @author J. Villing
 */
class Puzzle_2 {

    fun solve(t: Int, input: IntArray): Int {
        for (i: Int in input.indices) {
            for (j: Int in input.indices) {
                for (k: Int in input.indices) {
                    if (input[i] + input[j] + input[k] == t) {
                        println(input[i])
                        println(input[j])
                        println(input[k])
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