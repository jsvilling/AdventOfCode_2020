package `12`

import java.io.File
import java.lang.Exception

/**
 * @author J. Villing
 */
object Data {
    val inputSmall = listOf(
        "F10",
        "N3",
        "F7",
        "R90",
        "F11"
    )

    val input = File("src/main/resources/12/input12.txt").readLines()

}