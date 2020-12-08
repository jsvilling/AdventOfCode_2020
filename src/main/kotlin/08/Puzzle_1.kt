package `08`

import java.util.stream.Collectors

/**
 * @author J. Villing
 */
class Puzzle_1 {

    fun solve(input: List<String>): Int {
        val instructions = input.stream().map(this::toInstruction).collect(Collectors.toList())
        val executed: MutableSet<Int> = mutableSetOf()

        var acc = 0
        var i = 0

        while (!executed.contains(i)) {
            val current = instructions[i]
            executed.add(i)

            when (current.cmd) {
                "nop" -> {
                    i++
                }
                "acc" -> {
                    acc += current.num
                    i++
                }
                "jmp" -> {
                    i += current.num
                }
            }

        }

        return acc
    }

    private fun toInstruction(line: String): Instruction {
        val l = line.split(" ")
        return Instruction(l[0], Integer.valueOf(l[1]))
    }
}

data class Instruction(
    val cmd: String,
    val num: Int
)



fun main() {
    val res = Puzzle_1().solve(Data.input)
    print(res)
}