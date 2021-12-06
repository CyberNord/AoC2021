package cybernord.aoc2021.day5

import cybernord.aoc2021.readLines
import cybernord.aoc2021.remove
import cybernord.aoc2021.splitTwo

var content = "./test.txt".readLines()
//var content = "./input.txt".readLines()

class Point( val x: Int, val y: Int)
class Cord(val from: Point, val to: Point){

    fun compX():Boolean {
        return from.x == to.x
    }
    fun compY():Boolean {
        return from.y == to.y
    }
}


fun findMaxPoint(CordMap: List<Cord>): Pair<Int,Int>{
    TODO("return the rightBottom corner")
}


// the ultra mapping YAY :D
val cordMap = content.map{it.splitTwo("->")}
    .map{i -> Pair(i.first.remove(" ").splitTwo(","), i.second.remove(" ").splitTwo(","))}
    .map{p -> Cord(Point(p.first.first.toInt(), p.first.second.toInt()),Point(p.second.first.toInt(), p.second.second.toInt())) }

// TODO build Field

// Mark visited fields
for(c in cordMap){
    if (c.compX()){
        TODO()
    }else if(c.compY()){
        TODO()
    }
}

// tired --> resuming tomorrow
print("break")