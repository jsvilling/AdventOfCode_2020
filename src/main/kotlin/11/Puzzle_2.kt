
package `11`

/**
 * @author J. Villing
 */
class Puzzle_2 {

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
                    if (numNeighbors > 4) {
                        result[i] = result[i].replaceRange(j, j+1, "L")
                    }
                }
            }
        }
        return result
    }

    fun countNeighbours(row: Int, column: Int, input: List<String> ): Int {
        var count = 0
        val p = Position(row, column)
        for (d in directions) {
            if (nextVisibleSeat(d, p, input) == '#') {
                count++
            }
        }
        println(count)
        return count
    }

}

fun nextVisibleSeat(d: (Position) -> Position, start: Position, input: List<String>): Char {
    var p = d.invoke(start)
    while(input.indices.contains(p.x) && input[p.x].indices.contains(p.y)) {
        if (input[p.x][p.y] != '.') {
            return input[p.x][p.y]
        }
        p = d.invoke(p)
    }
    return '.'
}

data class Position(
    val x: Int,
    val y: Int
)

val directions = listOf(
    { p: Position -> Position(p.x-1, p.y-1) },
    { p: Position -> Position(p.x-1, p.y) },
    { p: Position -> Position(p.x-1, p.y+1) },
    { p: Position -> Position(p.x, p.y-1) },
    { p: Position -> Position(p.x, p.y+1) },
    { p: Position -> Position(p.x+1, p.y-1) },
    { p: Position -> Position(p.x+1, p.y) },
    { p: Position -> Position(p.x+1, p.y+1) },
)

fun main() {
    val result = Puzzle_2().solve(Data.input)
    println(result)
}
