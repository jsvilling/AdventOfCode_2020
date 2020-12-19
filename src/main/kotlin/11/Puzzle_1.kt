
package `11`

import java.util.stream.Collectors

/**
 * @author J. Villing
 */
class Puzzle_1 {


    fun solve(input: List<String>): Int {



        var prev = input
        var next = moveSeats(prev)

        while (!prev.equals(next)) {

            prev = next
            next = moveSeats(prev)

        }
        return next.stream().mapToInt { it.count { it == '#' } }.sum()

    }

    fun moveSeats(input: List<String>): MutableList<String> {
        val result = mutableListOf<String>()
        result.addAll(input)
        for (i: Int in input.indices) {
            val row = input[i]
            for (j: Int in row.indices) {
                if (row[j] != '.') {
                    var numNeighbors = countNeighbours(i, j, input)
                    if (numNeighbors == 0) {
                        result[i] = result[i].replaceRange(j, j+1, "#")
                    }
                    if (numNeighbors > 3) {
                        result[i] = result[i].replaceRange(j, j+1, "L")
                    }
                }
            }
        }
        return result
    }

    fun countNeighbours(row: Int, column: Int, input: List<String> ): Int {
        var count = 0
        for(i: Int in row-1..row+1) {
            if (i >= 0 && i < input.size ) {
                for (j: Int in column-1..column+1) {
                    if (j >= 0 && j < input[i].length && input[i][j] == '#' && !(i == row && j == column)) {
                        count++
                    }
                }
            }
        }
        return count
    }

}


fun main() {
    val result = Puzzle_1().solve(Data.input)
    println(result)
}
