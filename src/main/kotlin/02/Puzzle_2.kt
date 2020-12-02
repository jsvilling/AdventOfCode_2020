package `02`

import java.util.*

/**
 * @author J. Villing
 */
class Puzzle_2 {
    fun solve(input: Array<String>): Long {
        return Arrays.stream(input)
            .filter(this::isValidPasswordEntry)
            .count()
    }

    private fun isValidPasswordEntry(x: String): Boolean {
        val line: List<String> = x.split(" ", "-", ": ")

        val i: Int = Integer.valueOf(line.get(0)) - 1
        val j: Int = Integer.valueOf(line.get(1)) - 1
        val char: Char = line.get(2)[0]
        val password: String = line.get(3)

        return (password[i] == char).xor(password[j] == char)
    }
}

fun main(args: Array<String>) {
    val res: Long = Puzzle_2().solve(Data.input)
    print(res)
}