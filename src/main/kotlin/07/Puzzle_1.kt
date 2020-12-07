package `07`

import java.util.stream.Collectors

/**
 * @author J. Villing
 */
class Puzzle_1 {

    fun solve(input: List<String>): Long? {
        val rules = createRulesMap(input)
        return rules.entries
            .stream()
            .filter { c(it.value, mutableListOf(), rules) }
            .collect(Collectors.counting())
    }

    private fun createRulesMap(input: List<String>): MutableMap<String, List<String>> {
        val m: MutableMap<String, List<String>> = mutableMapOf()
        input.stream()
            .map { it.split("bags contain", " bag,", " bag.", " bags,", " bags.") }
            .forEach { m[it[0].trim()] =  toRulesList(it)}
        return m
    }

    private fun toRulesList(input: List<String>): List<String> {
        return input.stream()
            .skip(1)
            .filter { it.isNotEmpty() }
            .map { it.replace(Regex("[0-9]"), "") }
            .map { it.trim() }
            .collect(Collectors.toList())
    }


    private fun c(current: List<String>, checked: MutableList<String>, rules: Map<String, List<String>>): Boolean {
        if (current.contains("no other")) {
            return false
        }
        if (current.contains(Data.GOLD)) {
            return true
        }

        return current.stream()
            .filter { !checked.contains(it) }
            .anyMatch { c(rules[it]?: emptyList(), checked, rules) }
    }
}

fun main() {
    val res = Puzzle_1().solve(Data.input)
    print(res)
}