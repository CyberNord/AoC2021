package cybernord.aoc2021.day4

import cybernord.aoc2021.*

//start Time Measure
val start = System.currentTimeMillis()

// The problem-file
//var content = "./test.txt".readSections()
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

var boardsWon = Array(allSheet.size){false}
var numIdx = 0
var solution = arrayOf(0,0,0)
while(numIdx < nums.size){
    val currNum = nums[numIdx]
    for(sheets in 0 until data.size){
        if(!boardsWon[sheets]) {                        // will skip every board that lost already
            for (lines in 0 until data[sheets].size) {
                for (values in 0 until data[sheets][lines].size) {
                    if (data[sheets][lines][values] == currNum) {
                        gameSheets[sheets][lines][values] = true
                        val x = checkWin(sheets, lines, values, currNum)
                        if (x != null) {
                            solution = x
                        }
                    }
                }
            }
        }
    }
    numIdx++
}
var sol = solution[2]

print("Winner found, solutionCode: $sol\n")
print(System.currentTimeMillis() - start)
print(" milliseconds\n")


fun checkWin(sheets: Int, lines: Int, values: Int, currNum: Int): Array<Int>? {
    var win = true
    var sum = 0
    // check line
    for (index in 0 until gameSheets[sheets][lines].size) {
        if (!gameSheets[sheets][lines][index]) {
            win = false
        }
    }

    if (!win) {                 // not sure about corner case (two winners with one number) 
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
        boardsWon[sheets] = true        // exclude board
        return arrayOf(sum, currNum, sum * currNum)
    }
    return null
}

/*
Winner found, solutionCode: 13884
25 milliseconds
 */

