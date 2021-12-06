package cybernord.aoc2021.day5

import cybernord.aoc2021.readLines
import cybernord.aoc2021.remove
import cybernord.aoc2021.splitTwo
import kotlin.math.max

var content = "./test.txt".readLines()
//var content = "./input.txt".readLines()

class Point(var x: Int, var y: Int){
    fun increase() {
        x++
        y++
    }
    fun incY() { y++ }
    fun incX() { x++ }
    fun comparePoint(p: Point): Boolean{
        return x < p.x || y < p.y
    }
}
class Cord(val from: Point, val to: Point){
    fun compX():Boolean { return from.x == to.x }
    fun compY():Boolean { return from.y == to.y }
    fun findMax(): Int{ return max( max(from.x, from.y), max(to.x,to.y)) }
}

fun findMaxPoint(cordMap: List<Cord>): Int{
    var max = Int.MIN_VALUE
    for(i in cordMap){
        max = max(max, i.findMax())
    }
    return max
}



// the ultra mapping YAY :D
val cordMap = content.map{it.splitTwo("->")}
    .map{i -> Pair(i.first.remove(" ").splitTwo(","), i.second.remove(" ").splitTwo(","))}
    .map{p -> Cord(Point(p.first.first.toInt(), p.first.second.toInt()),Point(p.second.first.toInt(), p.second.second.toInt())) }

val fieldSize = findMaxPoint(cordMap)+1
var field = Array(fieldSize) {Array(fieldSize) {0} }


// TODO build Field

// Mark visited fields
for(c in cordMap){
    if (c.compX()){
        val fromP = c.from
        val toP = c.to
        while (fromP.comparePoint(toP)){
            field[fromP.x][fromP.y] +=1
            fromP.incY()
        }
    }else if(c.compY()) {
        val fromP = c.from
        val toP = c.to
        while (fromP.comparePoint(toP)) {
            field[fromP.x][fromP.y] += 1
            fromP.incX()
        }
    }
}
// not quite
for (i in field){
    for (j in i){
        print("[$j]")
    }
    println()
}

// tired --> resuming tomorrow
print("break")