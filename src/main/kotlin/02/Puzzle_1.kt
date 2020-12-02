package `02`

import java.util.*

/**
 * @author J. Villing
 */
class Puzzle_1 {

    fun solve(input: Array<String>): Long {
        return Arrays.stream(input)
            .filter(this::isValidPasswordEntry)
            .count()
    }

    fun isValidPasswordEntry(x: String): Boolean {
        val y: List<String> = x.split(" ", "-", ": ")

        val min: Int = Integer.valueOf(y.get(0))
        val max: Int = Integer.valueOf(y.get(1))
        val char: Char = y.get(2)[0]
        val password: String = y.get(3)
        var count = 0

        for (i: Int in password.indices) {
            if (char == password[i]) {
                count++
            }
        }

        return count in min..max;
    }




}

fun main(args: Array<String>) {
    val res: Long = Puzzle_1().solve(Data.input)
    print(res)
}