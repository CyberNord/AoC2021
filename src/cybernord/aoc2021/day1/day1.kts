package cybernord.aoc2021.day1

import cybernord.aoc2021.readLinesAsInt

// The problem-file
var content = "./input.txt".readLinesAsInt()


/*
Star 1

The Problem:
To do this, count the number of times a depth measurement increases from the previous measurement.
(There is no measurement before the first measurement.)
 */

var prev = Int.MAX_VALUE           // holds the prev value
var solution = 0                   // The solution

content.forEach { i ->
    when {
        i > prev -> solution++
    }
    prev = i
}

println(" Solution 1 Star : \n The number of times a depth measurement increases from the previous measurement: $solution")

/*
Star 2

The Problem:
Considering every single measurement isn't as useful as you expected: there's just too much noise in the data.
Instead, consider sums of a three-measurement sliding window.

Start by comparing the first and second three-measurement windows.
The measurements in the first window are marked A (199, 200, 208); their sum is 199 + 200 + 208 = 607.
The second window is marked B (200, 208, 210); its sum is 618.
The sum of measurements in the second window is larger than the sum of the first, so this first comparison increased.

Your goal now is to count the number of times the sum of measurements in this sliding window increases
from the previous sum. So, compare A with B, then compare B with C, then C with D, and so on.
Stop when there aren't enough measurements left to create a new three-measurement sum.
 */

// sort in the values into an array
var idx = 0                                                     // index of array
var valIdx = 0                                                  // value number in array 0 to 2
var data = Array(content.size+2) {Array(3) {0} }       // array to sort in values

while( idx < content.size){

    // Array[index][valuePosition] = value
    data[idx][valIdx] = content[idx]
    data[idx+1][valIdx] = content[idx]
    data[idx+2][valIdx] = content[idx]

    when {
        valIdx < 2 -> {
            valIdx++
        }
        else -> {
            valIdx = 0
        }
    }
    idx++
}

// Count the values that are bigger than the
// previous
prev = Int.MAX_VALUE
solution = 0
(2 until data.size).forEach { i ->
    val sum = data[i][0] + data[i][1] + data[i][2]
    if (sum > prev){
        solution++
    }
    prev = sum
}

println(" Solution 2 Star : \n The number of times a depth measurement increases from the previous measurement: $solution")
