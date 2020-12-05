package `05`

import java.util.*


/**
 * @author J. Villing
 */
class Puzzle_1 {

    fun solve(input: List<String>): Optional<Int> {
        return input.stream()
            .map { solve(it) }
            .max { o1, o2 ->  o1 - o2}
    }

    private fun solve(num: String): Int {
        var c = 128;

        var l = 0
        var m = 127

        for (i: Int in 0..6) {

            c /= 2

            if (num[i] == 'F') {
                m -= c
            }  else {
                l += c
            }

        }

        val row = l

        c = 8
        l = 0
        m = 7

        for (i: Int in 7..9) {

            c /= 2
            if (num[i] == 'L') {
                m -= c
            }  else {
                l += c
            }
        }
        val id = row * 8  + l
        return id

    }


}


fun main() {
    Puzzle_1()
        .solve(Data.input)
        .ifPresent { print(it) }
}