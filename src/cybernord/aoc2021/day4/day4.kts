package cybernord.aoc2021.day4

import cybernord.aoc2021.*

// The problem-file
//var content = "./test.txt".readSections()
val start = System.currentTimeMillis()

var content = "./input.txt".readSections()

val nums = content.first().split(',').map { i -> i.toInt() }
val allSheet = (content.subList(1,content.size).map { i -> arrayOf(i) })
var data = ArrayList<Array<Array<Int>>>()

// dunno I can't do it better
for(lines in allSheet){
    for(str in lines){
      data.add(str.splitLine().map{ i -> i.split(" ").filter { j -> j != "" }.map { it.toInt() }.toTypedArray() }.toTypedArray())
    }
}


val gameSheets = ArrayList<Array<Array<Boolean>>>()
repeat(allSheet.size){
    gameSheets.add(Array(5) {Array(5) {false} })
}



var numIdx = 0
var found = false
while(numIdx < nums.size && !found){            // will stop immeadiatly if a winner has been found
    val currNum = nums[numIdx]
    for(sheets in 0 until data.size){
        for(lines in 0 until data[sheets].size){
            for(values in 0 until data[sheets][lines].size){
                if(data[sheets][lines][values] == currNum){
                    gameSheets[sheets][lines][values] = true
                    if(checkWin(sheets,lines,values,currNum)){          // will check only the current row & collumn for winner
                        found = true
                    }
                    break
                }
            }
        }
    }
    numIdx++
}


fun checkWin(sheets: Int, lines: Int, values: Int, currNum: Int): Boolean {
    var win = true
    var sum = 0
    // check line
    for (index in 0 until gameSheets[sheets][lines].size) {
        if (!gameSheets[sheets][lines][index]) {
            win = false
        }
    }

    if (!win) {
        win = true
        // check row
        sum = 0
        for (index in 0 until gameSheets[sheets].size) {
            if (!gameSheets[sheets][index][values]) {
                win = false
            }
        }
    }

    if(win) {
        for (i in 0 until gameSheets[sheets].size) {
            for (j in 0 until gameSheets[sheets][i].size) {
                if (!gameSheets[sheets][i][j]) {
                    sum += data[sheets][i][j]
                }
            }
        }
        print("Winner found at grid: $sheets with Number $currNum Sum is $sum ==> ")
        println(sum * currNum)
        print(System.currentTimeMillis() - start)
        print(" milliseconds\n")
        return true
    }
    return false
}

/*
Winner found at grid: 79 with Number 46 Sum is 640 ==> 29440
22 milliseconds
 */

