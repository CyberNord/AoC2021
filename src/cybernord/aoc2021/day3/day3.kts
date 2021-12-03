package cybernord.aoc2021.day3

import cybernord.aoc2021.readLines

var content = "./input.txt".readLines()

/*
Star 1

The Problem:
Each bit in the gamma rate can be determined by finding the most common bit in the corresponding
position of all numbers in the diagnostic report.
 */


var gammaRateStr = ""
var len = content[0].length
var range = 0
var ones = 0
var zeros = 0

while (range < len){
    for( i in content){
        val x = i[range].toString()
        if(x == "0") zeros++ else if(x == "1") ones++
    }
    gammaRateStr += if(ones > zeros){"1"}else{"0"}
    range++
    ones = 0
    zeros = 0
}

var epsilonRateStr = ""
for(i in gammaRateStr){
    if (i == '0'){
        epsilonRateStr += "1"
    }else{
        epsilonRateStr += "0"
    }
}

println("Gamma Rate:   $gammaRateStr\nEpsilon Rate: $epsilonRateStr\n")

// why is there no shl in Byte,
// why "1010...".toByte() is out of range,
// why .inv of Byte 10 ==> -11 ? Byte operations are silly in Kotlin

// Manual calc from here : gammaRate.dec() * epsilonRate.dec() = solution