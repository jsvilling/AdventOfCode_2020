package `09`

import java.util.stream.Collectors

/**
 * @author J. Villing
 */
class Puzzle_2 {

    fun solve(input: List<String>, keySize: Int): Long {
        val nums = input.stream()
            .map { it.toLong() }
            .collect(Collectors.toList())

        val t = Puzzle_1().solve(input, keySize)

        val l = nums.indexOf(t)

        for (i: Int in 0..l) {
            var sum = 0L
            val res = mutableListOf<Long>()
            var j = i
            while (sum < t) {
                sum += nums[j]
                res.add(nums[j])
                j++
            }
            if (sum == t) {
                res.sort()
                println(res[0])
                println(res[res.size-1])
                return res[0] + res[res.size-1]
            }
        }

        return -1
    }



}

fun main() {
    val res = Puzzle_2().solve(Data.input, Data.keyLength)
    print(res)
}