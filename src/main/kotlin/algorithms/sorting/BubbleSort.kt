package algorithms.sorting

fun sort(array: Array<Int>) { // O(n^2)

    for (x in array.size - 1 downTo 0) {

        for (i in 0 until x) {

            if (array[i] > array[i + 1]) {
                val temp = array[i]
                array[i] = array[i + 1]
                array[i + 1] = temp
            }

            println(array.contentToString())
        }
    }
}

fun main() {

    val array = arrayOf(8, 7, 6, 5, 4, 3, 2, 1)
    sort(array)
//    println(array.contentToString())
}