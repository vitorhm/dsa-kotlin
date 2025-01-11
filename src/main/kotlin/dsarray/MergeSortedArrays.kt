package dsarray

fun merge(arr1: Array<Int>, arr2: Array<Int>) = arr1.plus(arr2).sortedArray()

fun merge2(arr1: Array<Int>, arr2: Array<Int>): Array<Int> {
    val arr3 = arr1 + arr2
    return arr3.sortedArray()
}

fun main() {

    val arr1 = arrayOf(1, 3, 5)
    val arr2 = arrayOf(2, 4, 6)

    println(merge(arr1, arr2).toList())
    println(merge2(arr1, arr2).toList())
}