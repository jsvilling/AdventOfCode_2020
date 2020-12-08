package `08`

import java.io.File
import java.lang.Exception

/**
 * @author J. Villing
 */
object Data {
    val inputSmall = listOf(
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"
    )

    val input = File("src/main/resources/08/input8.txt").readLines()

}