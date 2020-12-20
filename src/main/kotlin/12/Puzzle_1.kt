package `12`

import kotlin.math.absoluteValue

/**
 * @author J. Villing
 */
class Puzzle_1 {


    fun solve(input: List<String>): Int {
        var ship = Ship(0, 0, 0)
        for (c in input) {
            val commandKey = c[0]
            val i = Integer.valueOf(c.substring(1 until c.length))
            val command = findCommand(commandKey, ship)
            ship = command.invoke(ship, i)
        }
        return ship.north.absoluteValue + ship.east.absoluteValue
    }

    private fun findCommand(key: Char, ship: Ship): (Ship, Int) -> Ship {
        val command = commands[key]
        if (command != null) {
            return command
        }
        val orientation = getOrientationByDeg(ship.orientation)
        return commands[orientation]!!
    }
}

data class Ship(
    val east: Int,
    val north: Int,
    val orientation: Int
)

private val commands = mapOf(
    'N' to { s: Ship, i: Int -> Ship(s.east, s.north + i, s.orientation) },
    'S' to { s: Ship, i: Int -> Ship(s.east, s.north - i, s.orientation) },
    'E' to { s: Ship, i: Int -> Ship(s.east + i, s.north, s.orientation) },
    'W' to { s: Ship, i: Int -> Ship(s.east - i, s.north, s.orientation) },
    'L' to { s: Ship, i: Int -> Ship(s.east, s.north, (s.orientation + 360 - i) % 360) },
    'R' to { s: Ship, i: Int -> Ship(s.east, s.north, (s.orientation + i) % 360) }
)

fun getOrientationByDeg(deg: Int): Char = when (deg) {
    0 -> {
        'E'
    }
    90 -> {
        'S'
    }
    180 -> {
        'W'
    }
    else -> 'N'
}

fun main() {
    val result = Puzzle_1().solve(Data.input)
    println(result)
}
