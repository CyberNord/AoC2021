package cybernord.aoc2021.day4

import cybernord.aoc2021.*

// The problem-file
var content = "./test.txt".readSections()

val nums = content.first().split(',').map { i -> i.toInt() }
val sheets = (content.subList(1,content.size).map { i -> arrayOf(i) })
var data = ArrayList<ArrayList<Int>>()

for(lines in sheets){
    for(str in lines){
        var x = str.splitLine().map{ i -> i.split(" ").filter { j -> j != "" } }



//        data.add(x)

        println("$x ")
    }
}




println("done")
