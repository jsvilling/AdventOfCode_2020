package `01`

import java.util.*


/**
 * @author J. Villing
 */
class Puzzle_1 {

    fun solve(t: Int, input: IntArray): Int {
        Arrays.sort(input)
        val j: Int = lineSearch(input, t/2, 0)
        for (i: Int in 0..j) {
            val k: Int = lineSearch(input, t-input[i], j)
            if ( k < input.size && input[i] + input[k] == t) {
                print(input[i])
                print("    ")
                print(input[k])
                return input[i] * input[k]
            }
        }
        return -1;
    }

    private fun lineSearch(data: IntArray, t: Int, i: Int): Int {
        var res: Int = i;
        while (res < data.size && data[res] < t) {
            res++;
        }
        return res;
    }

}

fun main(args: Array<String>) {
    val r: Int = Puzzle_1().solve(Data.x, Data.input)
    print(r)
}

