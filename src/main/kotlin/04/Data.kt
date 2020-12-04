package `04`

import java.io.File

/**
 * @author J. Villing
 */
object Data {
    val input = File("src/main/resources/input.txt").readLines()
    val inputSmall = File("src/main/resources/inputsmall.txt").readLines()
    val props = listOf<String>(
        "byr",
        "iyr",
        "eyr",
        "hcl",
        "hgt",
        "ecl",
        "pid"
    )
}