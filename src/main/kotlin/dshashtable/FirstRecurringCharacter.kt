package dshashtable

// Find recurring character with time > space
fun findFavoringSpaceComplexity(array: Array<Int>): Int? {

    for (i in array) {

        for (x in i+1 until array.size) {
            if (i == array[x]) {
                return i
            }
        }
    }

    return null

    // Time Complexity  -> O(n²) -> Nested Loop
    // Space Complexity -> O(1)
}

// Find recurring character with space > time
fun findFavoringTimeComplexity(array: Array<Int>): Int? {

    val hashSet = hashSetOf<Int>()

    for (i in array) {
        if (hashSet.contains(i)) return i
        hashSet.add(i)
    }

    return null

    // Time Complexity  -> O(n)
    // Space Complexity -> O(n) -> We create a new hashset with the size of (n)
}

fun main() {

    println(findFavoringSpaceComplexity(arrayOf(1, 2, 5, 4, 5, 3, 4, 5))) // 5
    println(findFavoringSpaceComplexity(arrayOf(1, 2, 3, 4))) // null

    println(findFavoringTimeComplexity(arrayOf(1, 2, 5, 4, 5, 3, 4, 5))) // 5
    println(findFavoringTimeComplexity(arrayOf(1, 2, 3, 4))) // null

}