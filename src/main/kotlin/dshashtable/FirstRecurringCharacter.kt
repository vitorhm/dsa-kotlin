package dshashtable

fun find(array: Array<Int>): Int? {

    val hashSet = hashSetOf<Int>()

    for (i in array) {
        if (hashSet.contains(i)) return i
        hashSet.add(i)
    }

    return null
}

fun main() {

    println(find(arrayOf(1, 2, 5, 4, 5, 3, 4, 5))) // 5
    println(find(arrayOf(1, 2, 3, 4))) // null

}