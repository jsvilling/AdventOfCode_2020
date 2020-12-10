package `10`

import java.util.stream.Collectors

/**
 * @author J. Villing
 */
class Puzzle_1 {

    val jolts: MutableList<Int>
    val target: Int

    var diffOne = 0
    var diffThree = 0

    constructor(input: List<String>) {
        jolts = input.stream()
            .map { it.toInt() }
            .collect(Collectors.toList())
        target = jolts.last()
    }

    fun solve(model: MutableList<Int>) {

        if (model.size == jolts.size) {
            print("yippi")
        } else {
            val prev = model.last()

            val i = model.lastIndex
            model.add(jolts[i+1])
            solve(model)
            model.removeAt(i+1)

            model.add(jolts[i+2])
            solve(model)
            model.removeAt(i+2)

            model.add(jolts[i+3])
            solve(model)
            model.removeAt(i+3)

            // TODO: break on found
        }


    }

    fun check(model: List<Int>): Boolean {
        return model.size == jolts.size
    }


}


fun main() {
}