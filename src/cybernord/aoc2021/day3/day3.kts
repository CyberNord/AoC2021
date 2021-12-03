package cybernord.aoc2021.day3

import cybernord.aoc2021.readLines

val content = "./input.txt".readLines()
val bitLength = content[0].length

solveProblem1()

solveProblem2()

/*
Star 1

The Problem:
Each bit in the gamma rate can be determined by finding the most common bit in the corresponding
position of all numbers in the diagnostic report.
 */
fun solveProblem1(){

    var gammaRateStr = ""
    var epsilonRateStr = ""
    var range = 0
    var ones = 0
    var zeros = 0

    while (range < bitLength){
        for( i in content){
            val x = i[range].toString()
            if(x == "0") zeros++ else if(x == "1") ones++

        }
        gammaRateStr += if(ones > zeros){"1"}else{"0"}
        range++
        ones = 0
        zeros = 0
    }

    for(i in gammaRateStr){
        epsilonRateStr += if (i == '0'){"1"}else{"0"}
    }
    val solution = gammaRateStr.toInt(2)*epsilonRateStr.toInt(2)
    println("Gamma Rate: $gammaRateStr\nEpsilon Rate: $epsilonRateStr\n --> Solution for 1.Star = $solution\n")

}
//-------------------------------------------------------------------------------------------------------

/*
Star 2

The Problem:
Keep only numbers selected by the bit criteria for the type of rating value for which you are searching.
Discard numbers which do not match the bit criteria.
If you only have one number left, stop; this is the rating value for which you are searching.
Otherwise, repeat the process, considering the next bit to the right.
The bit criteria depends on which type of rating value you want to find:

To find oxygen generator rating, determine the most common value (0 or 1) in the current bit position,
and keep only numbers with that bit in that position. If 0 and 1 are equally common,
keep values with a 1 in the position being considered.
To find CO2 scrubber rating, determine the least common value (0 or 1) in the current bit position,
and keep only numbers with that bit in that position. If 0 and 1 are equally common,
keep values with a 0 in the position being considered.
 */

fun solveProblem2() {


    var ones = 0
    var zeros = 0
    var posCounter = 0
    var oxygen = mutableMapOf<Int, String>()
    var carbondioxide = mutableMapOf<Int, String>()

    var oxygenInt = 0
    var carbondioxideInt = 0


    content.forEach { i ->
        oxygen[posCounter] = i
        carbondioxide[posCounter]= i
        posCounter++
    }

    var range = 0

    // oxygen
    while (range < bitLength){
        val mapZeros = mutableMapOf<Int, String>()
        val mapOnes = mutableMapOf<Int, String>()
        for( i in oxygen){
            val x = i.value[range]
            if(x == '0') {
                mapZeros[i.key] = i.value
                zeros++
            }else if(x == '1') {
                mapOnes[i.key] = i.value
                ones++
            }
        }
        oxygen = if(ones >= zeros){ mapOnes }else{ mapZeros }
        if(oxygen.size == 1){
            oxygen.forEach { i -> oxygenInt = i.value.toInt(2) }
        }
        range++
        ones = 0
        zeros = 0
    }

    range = 0
    ones = 0
    zeros = 0

    // carbondioxide
    while (range < bitLength){
        val mapZeros = mutableMapOf<Int, String>()
        val mapOnes = mutableMapOf<Int, String>()
        for( i in carbondioxide){
            val x = i.value[range]
            if(x == '0') {
                mapZeros[i.key] = i.value
                zeros++
            }else if(x == '1') {
                mapOnes[i.key] = i.value
                ones++
            }
        }
        carbondioxide = if(ones >= zeros){ mapZeros }else{ mapOnes }
        if(carbondioxide.size == 1){
            carbondioxide.forEach { i -> carbondioxideInt = i.value.toInt(2) }
        }
        range++
        ones = 0
        zeros = 0
    }

    print("CO2 = $carbondioxideInt \nO2 = $oxygenInt\n --> Solution for 1.Star = ")
    println(carbondioxideInt*oxygenInt)
}