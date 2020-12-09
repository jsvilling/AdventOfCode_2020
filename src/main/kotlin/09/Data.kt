package `09`

import java.io.File
import java.lang.Exception

/**
 * @author J. Villing
 */
object Data {
    val inputSmall = listOf(
        "35",
        "20",
        "15",
        "25",
        "47",
        "40",
        "62",
        "55",
        "65",
        "95",
        "102",
        "117",
        "150",
        "182",
        "127",
        "219",
        "299",
        "277",
        "309",
        "576"
    )
    const val keyLengthSmall =  5
    const val keyLength = 25


    val input = File("src/main/resources/09/input9.txt").readLines()

}