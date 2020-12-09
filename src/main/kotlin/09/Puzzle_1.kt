package `09`

import java.util.*
import java.util.stream.Collectors

/**
 * @author J. Villing
 */
class Puzzle_1 {

    fun solve(input: List<String>, keySize: Int): Long {
        val nums = input.stream()
            .map { it.toLong() }
            .collect(Collectors.toList())

        for (i: Int in keySize..nums.size) {
            val sub = nums.subList(i - keySize, i).toLongArray()
            val sol = NumPairWithSumSolver.solve(nums[i], sub)
            if (sol == -1L) {
                return nums[i]
            }
        }
        return -1
    }

}

object NumPairWithSumSolver {
    fun solve(t: Long, input: LongArray): Long {
        Arrays.sort(input)
        val j: Int = lineSearch(input, t/2L, 0)
        for (i: Int in 0..j) {
            val k: Int = lineSearch(input, t-input[i], j)
            if ( k < input.size && input[i] + input[k] == t) {
                return input[i] * input[k]
            }
        }
        return -1;
    }

    private fun lineSearch(data: LongArray, t: Long, i: Int): Int {
        var res: Int = i;
        while (res < data.size && data[res] < t) {
            res++;
        }
        return res;
    }
}


fun main() {
    val res = Puzzle_1().solve(Data.input, Data.keyLength)
    print(res)
}