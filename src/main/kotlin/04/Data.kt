package `04`

import java.io.File
import java.lang.Exception

/**
 * @author J. Villing
 */
object Data {
    val input = File("src/main/resources/04/input.txt").readLines()
    val inputSmall = File("src/main/resources/04/inputsmall.txt").readLines()
    val inputSmallValidation = File("src/main/resources/04/inputsmallvalidation.txt").readLines()
    val props = listOf(
        "byr",
        "iyr",
        "eyr",
        "hcl",
        "hgt",
        "ecl",
        "pid"
    )
    val hcls = listOf(
        "amb",
        "blu",
        "brn",
        "gry",
        "grn",
        "hzl",
        "oth"
    )
    val rules: Map<String, (String) -> Boolean> = mapOf(
        Pair("byr", { e: String -> e.length== 4 &&  Integer.valueOf(e) in IntRange(1920, 2020)  }  ),
        Pair("iyr", { e: String ->  e.length== 4 &&  Integer.valueOf(e) in IntRange(2010, 2020)  }  ),
        Pair("eyr", { e: String ->  e.length== 4 &&  Integer.valueOf(e) in IntRange(2020, 2030)  }  ),
        Pair("hgt", { e: String ->  valHeight(e)} ),
        Pair("hcl", { e: String ->  e.length == 7 && e[0] == '#' && e.substring(1, 7).matches(Regex("^[0-9 a-f]*\$"))}),
        Pair("ecl", { e: String ->  hcls.contains(e)}),
        Pair("pid", { e: String ->  e.length == 9 && e.matches(Regex("^[0-9]*\$"))})
    )


    private fun valIntRange(e: String, lower: Int, upper: Int): Boolean {
        try {
            return Integer.valueOf(e) in IntRange(lower, upper)
        } catch (e: Exception) {
        }
        return false
    }

    private fun valHeight(e: String): Boolean {
        val unit = e.substring(e.length -2, e.length)
        if (unit == "cm") {
            return valIntRange(e.substring(0, e.length - 2), 150, 193)

        } else if (unit == "in") {
            return valIntRange(e.substring(0, e.length - 2), 59, 76)
        }
        return false;
    }
}