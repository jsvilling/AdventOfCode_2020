package `06`

import java.io.File
import java.lang.Exception

/**
 * @author J. Villing
 */
object Data {
    val inputSmall = listOf(
        "abc",
        "",
        "a",
        "b",
        "c",
        "",
        "ab",
        "ac",
        "",
        "a",
        "a",
        "a",
        "a",
        "",
        "b",
    )
    val input = File("src/main/resources/06/input.txt").readLines()

}