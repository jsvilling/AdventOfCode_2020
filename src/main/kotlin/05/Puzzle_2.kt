package `05`

import java.util.stream.Collectors

/**
 * @author J. Villing
 */
class Puzzle_2 {

    fun solve(input: List<String>): Int {

        val usedSeats = input.stream()
            .map { Puzzle_1().solve(it) }
            .collect(Collectors.toList())

        val availableIds: MutableList<Int> = mutableListOf()

        for (i: Int in 0..127) {
            for(j: Int in 0..7) {
                availableIds.add(i*8+j)
            }
        }

        availableIds.removeAll(usedSeats)

        // We know it's not at the front. So we keep removing the first and last available row until only the needed seat remains
        var l = 127
        var m = 0
        while (availableIds.size > 1) {
            availableIds.removeIf { it > l*8 || it < m*8+7 }
            l--
            m++
        }

        return availableIds[0]
    }

}


fun main() {
    val res = Puzzle_2().solve(Data.input)
    print(res)
}