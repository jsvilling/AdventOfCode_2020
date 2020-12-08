package `08`

import java.util.stream.Collectors
import java.util.stream.IntStream

/**
 * @author J. Villing
 */
class Puzzle_2 {

    fun solve(input: List<String>): Int {
        val instructions = input.stream().map(this::toInstruction).collect(Collectors.toList())

        val jmps: MutableList<Int> = mutableListOf()
        for (j: Int in instructions.indices) {
            if (instructions[j].cmd == "jmp") {
                jmps.add(j)
            }
        }

        for (j: Int in jmps) {
            var acc = 0
            var i = 0
            val executed: MutableSet<Int> = mutableSetOf()
            while (!executed.contains(i) && i < instructions.size) {
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
                        if (i == j) {
                            i++
                        } else {
                            i += current.num
                        }
                    }
                }
            }
            if (i == instructions.size) {
                return acc
            }
        }

        throw IllegalStateException("Instruction cannot be corrected")
    }

    private fun toInstruction(line: String): Instruction {
        val l = line.split(" ")
        return Instruction(l[0], Integer.valueOf(l[1]))
    }
}


fun main() {
    val res = Puzzle_2().solve(Data.input)
    print(res)
}