package cybernord.aoc2021.day1

import cybernord.aoc2021.readContent
import cybernord.aoc2021.readLinesAsInt
import kotlin.coroutines.coroutineContext

var content = "./input.txt".readLinesAsInt()

//println("DEBUG $content")

var prev = content[0]
val inpLen = content.size
// println(" DEBUG  first parameter is: $prev and the overall size is $inpLen")

var counter = 0;
var debugLen = 0;

for(i in content){
    if (i > prev){
        counter++
        // println(" DEBUG i parameter is: $i and prev is $prev -->  counter increased to $counter")
    }else{
        // println(" DEBUG  parameter is: $i and prev is $prev -->  counter stays the same at $counter")
    }
    prev = i;
    debugLen++
}

// println(" DEBUG Performed comparisons: $debugLen")
println(" Solution \n The number of times a depth measurement increases from the previous measurement: $counter")