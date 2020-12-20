package `12`

import java.awt.Point
import kotlin.math.*


/**
 * @author J. Villing
 */
class Puzzle_2 {

    fun solve(input: List<String>): Int {
        val wayPoint = WayPoint(10, 1)
        var ship = WayPointShip(0, 0, wayPoint)
        for (c in input) {
            val commandKey = c[0]
            val i = Integer.valueOf(c.substring(1 until c.length))


            if (commandKey == 'F') {
                ship = shipCommand(ship, i)
            } else {
                waypointCommands[commandKey]?.invoke(ship, i)!!.also { ship = it }
            }
            println(ship)
            println(ship.wayPoint)
            println()
        }
        return ship.north.absoluteValue + ship.east.absoluteValue
    }

}

data class WayPoint(
    val east: Int,
    val north: Int
)

data class WayPointShip(
    val east: Int,
    val north: Int,
    val wayPoint: WayPoint
)

val waypointCommands = mapOf(
    'N' to { s: WayPointShip, i: Int -> WayPointShip(s.east, s.north, WayPoint(s.wayPoint.east, s.wayPoint.north + i)) },
    'S' to { s: WayPointShip, i: Int -> WayPointShip(s.east, s.north, WayPoint(s.wayPoint.east, s.wayPoint.north - i)) },
    'E' to { s: WayPointShip, i: Int -> WayPointShip(s.east, s.north, WayPoint(s.wayPoint.east + i, s.wayPoint.north)) },
    'W' to { s: WayPointShip, i: Int -> WayPointShip(s.east, s.north, WayPoint(s.wayPoint.east - 1, s.wayPoint.north)) },
    'R' to { w: WayPointShip, i: Int ->
        val rad = -i * Math.PI / 180

        val c = cos(rad)
        val s = sin(rad)

        val y = w.wayPoint.east
        val x = w.wayPoint.north

        val eastNew = (x * c - y * s).roundToInt()
        val northNew = (x * s + y * c).roundToInt()

        WayPointShip(w.east, w.north, WayPoint(eastNew, northNew)) },

    'L' to { w: WayPointShip, i: Int ->
        val rad = i * Math.PI / 180

        val c = cos(rad)
        val s = sin(rad)

        val x = w.wayPoint.east
        val y = w.wayPoint.north

        val eastNew = (x * c - y * s).roundToInt()
        val northNew = (x * s + y * c).roundToInt()

        WayPointShip(w.east, w.north, WayPoint(eastNew, northNew)) },

    )

fun shipCommand(ship: WayPointShip, i: Int): WayPointShip {
    return WayPointShip(ship.east + i * ship.wayPoint.east, ship.north + i*ship.wayPoint.north, ship.wayPoint)
}

fun main() {
    val result = Puzzle_2().solve(Data.inputSmall)
    println(result)
}
