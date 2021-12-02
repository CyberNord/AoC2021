package cybernord.aoc2021.day2

import cybernord.aoc2021.readLines
import cybernord.aoc2021.remove

/*
Star 1
The Problem:
Now, you need to figure out how to pilot this thing.

It seems like the submarine can take a series of commands like forward 1, down 2, or up 3:
forward X increases the horizontal position by X units.
down X increases the depth by X units.
up X decreases the depth by X units.
Note: down and up affect your depth inverse 

Your horizontal position and depth both start at 0.
What do you get if you multiply your final horizontal position by your final depth?
 */

val plannedCourse = "./input.txt".readLines()
//val plannedCourse = "./test.txt".readLines()
var down = "down"
var up = "up"
var forward = "forward"

var depth = 0
var horizontal = 0

plannedCourse.forEach{ s ->
    if(s.contains(forward)){
        horizontal += s.remove("$forward ").toInt()
    }else if(s.contains(up)) {
        depth -= s.remove("$up ").toInt()
    }else if(s.contains(down )) {
        depth += s.remove("$down ").toInt()
    }
}

val solution = depth*horizontal
println(" Solution 1.Star := $depth * $horizontal = $solution")


/*
Star 2
The Problem
You'll also need to track a third value, aim, which also starts at 0.

down X increases your aim by X units.
up X decreases your aim by X units.
forward X does two things:
    It increases your horizontal position by X units.
    It increases your depth by your aim multiplied by X.
Again :  "down" means aiming in the positive direction "" up means negative.

What do you get if you multiply your final horizontal position by your final depth?
 */

depth = 0           // reset
horizontal = 0      // reset
var aim = 0

plannedCourse.forEach{ s ->
    if(s.contains(forward)){
        val x = s.remove("$forward ").toInt()
        horizontal += x
        depth += aim * x
    }else if(s.contains(up)) {
        aim -= s.remove("$up ").toInt()
    }else if(s.contains(down )) {
        aim += s.remove("$down ").toInt()
    }
}

val solution2 = depth*horizontal
println(" Solution 2.Star := $depth * $horizontal = $solution2")
