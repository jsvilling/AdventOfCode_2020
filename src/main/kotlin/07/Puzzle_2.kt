package `07`

import java.util.stream.Collectors

/**
 * @author J. Villing
 */
class Puzzle_2 {
    fun solve(input: List<String>): Int {
        val rules = createRulesMap(input)
        return numRequired(Data.GOLD, rules)
    }

    private fun numRequired(color: String, rules: Map<String, List<Rule>>): Int {
        val goldenRules = rules[color]?: listOf()
        return goldenRules.stream()
            .mapToInt { numRequiredCurrentLevel(it, rules) }
            .sum()
    }

    private fun numRequiredCurrentLevel(rule: Rule, rules: Map<String, List<Rule>>): Int {
        val relevantRules = rules[rule.color]?: listOf()
        val currentLevelSum = relevantRules.stream()
            .mapToInt { numRequiredCurrentLevel(it, rules) }
            .sum()
        return rule.num + rule.num * currentLevelSum
    }

    private fun createRulesMap(input: List<String>): MutableMap<String, List<Rule>> {
        val m: MutableMap<String, List<Rule>> = mutableMapOf()
        input.stream()
            .map { it.split("bags contain", " bag,", " bag.", " bags,", " bags.") }
            .forEach { m[it[0].trim()] =  toRulesList(it)}
        return m
    }

    private fun toRulesList(input: List<String>): List<Rule> {
        return input.stream()
            .skip(1)
            .filter { it.isNotEmpty() }
            .map { Rule(getLeadingNumber(it), it.replace(Regex("[0-9]"), "").trim()) }
            .collect(Collectors.toList())
    }

    private fun getLeadingNumber(s: String): Int {
        try {
            return Integer.valueOf(s.split(" ")[1])
        } catch(e: Exception) { }
        return 0
    }

}

data class Rule(
    val num: Int,
    val color: String
)

fun main() {
    val res = Puzzle_2().solve(Data.input)
    print(res)
}