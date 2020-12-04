package `04`

import java.io.File

/**
 * @author J. Villing
 */
object Data {
    val input = File("src/main/resources/04/input.txt").readLines()
    val inputSmall = File("src/main/resources/04/inputsmall.txt").readLines()
    val props = listOf(
        "byr",
        "iyr",
        "eyr",
        "hcl",
        "hgt",
        "ecl",
        "pid"
    )
}