package com.ph30891.lab1_ph30891

import kotlin.math.abs

fun main() {
    println("=== Trần Hoàng Long - PH30891 ===")
    do {
        print("Chon bai muon chay (1, 2, 3) : ")
        var choice = readLine()
        when (choice) {
            "1" -> bai1()
            "2" -> bai2()
            "3" -> bai3()
            else -> print("Lua chon khong hop le")
        }
    } while (choice != "")
}

fun bai1() {
    print("Nguyen Van Anh - PS123456\n")
    print("=========================\n")
    println("Quanh năm buôn bán ở mom sông")
    println("Nuôi đủ năm con với một chồng")
    println("\tlặn lội thân cờ khi quãng vằng")
    println("\tteo sèo mặt nước buổi đò đông")
    println("Một duyên hai nợ âu đành phận")
    println("Năm nắng mười mưa há chẳng công")
    println("\tCha mẹ thói đời \"ăn ở bạc\"")
    println("\tCó chồng hờ hững cũng như không")
}

fun bai2() {
    var a = 0.0
    var b = 0.0
    print("Nhap a : ")
    var s = readLine()
    if (s != null) a = s.toDouble()
    print("Nhap b : ")
    s = readLine()
    if (s != null) b = s.toDouble()

    println("Tong : " + (a + b))
    println("Hieu : " + (a - b))
    println("Tich : " + (a * b))
    println("Thuong : " + (a / b))
}

fun bai3() {
    // vd 1 : for
    println("== vd 1 : for =============================")
    val cakes = listOf("carrot", "cheese", "chocolate")
    for (cake in cakes) {
        println("Long, it's a $cake cake?")
    }

    // vd 2 : when, do white
    println("== vd 2 : when, do white =============================")
    fun eatCake(number: Int) = println("Eat $number cake !")
    fun makeCake(number: Int) = println("Make $number cake !")

    var cakesEaten = 1
    var cakesMade = 1

    while (cakesEaten < 5) {
        eatCake(cakesEaten)
        cakesEaten++
    }

    do {
        makeCake(cakesMade)
        cakesMade++
    } while (cakesMade < cakesEaten)

    // vd 3 : ranges
    println("== vd 3 : ranges =============================")
    for (i in 0..3) {
        print(i)
    }
    print(" | ")

    for (i in 0 until 4) {
        print(i)
    }
    print(" | ")

    for (i in 0..10 step 2) {
        print(i)
    }
    print(" | ")

    for (i in 5 downTo 0) {
        print(i)
    }
    println()

    // vd 4: Char ranges
    println("== vd 4: Char ranges =============================")
    for (char in 'a'..'d') {
        print(char)
    }
    print(" | ")

    for (char in 'd' downTo 'a') {
        print(char)
    }
    print(" | ")

    // vd 5: Max min
    println("== vd 5: Max min =============================")
    fun max(a: Int, b: Int) = if (a > b) a else b
    fun min(a: Int, b: Int) = if (a < b) a else b
    println("So max la : ${max(9, 10)}")
    println("So min la : ${min(5, 6)}")

    // vd 5: Lambda function
    println("== vd 5: Lambda function =============================")
    val upperCase1: (String) -> String = { str: String -> str.uppercase() }
    val upperCase2: (String) -> String = { str -> str.uppercase() }
    val upperCase3 = { str: String -> str.uppercase() }
    val upperCase4: (String) -> String = { it.uppercase() }
    val upperCase5: (String) -> String = String::uppercase
    println(upperCase1("tran hoang long"))
    println(upperCase2("tran hoang long"))
    println(upperCase3("tran hoang long"))
    println(upperCase4("tran hoang long"))
    println(upperCase5("tran hoang long"))

    // vd 6: filter
    println("== vd 6: filter =============================")
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val positives = numbers.filter { x -> x > 0 }
    val nagatives = numbers.filter { it < 0 }
    println(positives)
    println(nagatives)

    // vd 7: map
    println("== vd 7 : map =============================")
    val doubled = numbers.map { x -> x * 2 }
    val tripled = numbers.map { it * 3 }
    println(doubled)
    println(tripled)

    // vd 8: any, all, none
    println("== vd 8: any, all, none =============================")
    val anyNegative = numbers.any { it < 0 }
    val anyGT6 = numbers.any { it > 6 }
    println("Numbers: $numbers")
    println("Is there any number less than 0: $anyNegative")
    println("Is there any number greater than 6: $anyGT6")

    val allEven = numbers.all { it % 2 == 0 }
    val allLess6 = numbers.all { it < 6 }
    println("Numbers: $numbers")
    println("All numbers are even: $allEven")
    println("All numbers are less than 6: $allLess6")

    val allEvens = numbers.none { it % 2 == 0 }
    val allLess6s = numbers.none { it > 6 }
    println("Numbers: $numbers")
    println("All numbers are even: $allEvens")
    println("No element greater than 6: $allLess6s")

    //vd : 9 find, findLast
    println("== vd : 9 find, findLast =============================")
    val words = listOf("Lets", "find", "something", "in", "somehow", "collection")
    val first = words.find { it.startsWith("some") }
    val last = words.findLast { it.startsWith("some") }
    val nothing = words.find { it.contains("nothing") }
    println("Từ đầu tiên trong mảng bắt đầu bằng \"some\" là : \"$first\"")
    println("Từ cuối cùng trong mảng bắt đầu bằng \"some\" là : \"$last\"")
    println("Từ đầu tiên chứa \"nothing\" là : \"$nothing\"")

    //vd : 10 first, last
    println("== vd : 10 first, last =============================")
    val soDau = numbers.first();
    val soCuoi = numbers.last();
    val firstEven = numbers.first{ it % 2 == 0}
    val lastOdd = numbers.last{it % 2 != 0}
    println("Numbers: $numbers")
    println("First $soDau, last $soCuoi, first even $firstEven, last odd $lastOdd")

    // vd 11: count
    println("== vd 11: count =============================")
    val totalCount = numbers.count()
    val evenCount = numbers.count { it % 2 == 0 }
    println("Total number of elements : $totalCount")
    println("Number of even elements: $evenCount")

    //vd 12 : partition
    println("== vd 12 : partition =============================")
    val evenOdd = numbers.partition { it % 2 == 0}
    val (positive, negative) = numbers.partition { it > 0 }
    println("Even numbesr : ${evenOdd.first}")
    println("Odd numbers : ${evenOdd.second}")
    println("Positive numbers: $positive")
    println("Negative numbers: $negative")

    // vd 13 : flatMap
    println("== vd 13 : flatMap =============================")
    val fruitCart = listOf("apple","orange","banana","grapes")
    val clothesCart = listOf("shirts", "pants", "jeans")
    val cart = listOf(fruitCart, clothesCart)
    val mapCart = cart.map { it }
    val flatMapCart = mapCart.flatMap { it }
    println("My cart are : $mapCart")
    println("The things I bought are : $flatMapCart")

    // vd 14 : sorted
    println("== vd 14 : sorted =============================")
    val shuffled = listOf(5, 4, 0, 2, 1, 3, -1)
    val natural = shuffled.sorted()
    val inverted = shuffled.sortedBy { -it }
    val descending = shuffled.sortedDescending()
    val descendingBy = shuffled.sortedByDescending { abs(it) }
    println("Shuffled: $shuffled")
    println("Natural order: $natural")
    println("Inverted natural order: $inverted")
    println("Inverted natural order value: $descending")
    println("Inverted natural order of absolute values: $descendingBy")

    // vd 15: zip
    println("== vd 15 : zip =============================")
    val A = listOf("a", "b", "c")
    val B = listOf(1, 2, 3, 4)

    val resultPairs = A zip B
    val resultReduce = A.zip(B) { a, b -> "$a$b" }

    println("A to B: $resultPairs")
    println("\$A\$B: $resultReduce")
}

class Lab1_KOT104 {
}