package algorithms.sorting

fun selectionSort(array: Array<Int>) {

    for (pointerIndex in array.indices) {

        println(array.contentToString())

        var smallestIndex: Int = pointerIndex

        for (currentIndex in pointerIndex + 1 until array.size) {

            if (array[currentIndex] < array[smallestIndex]) {
                smallestIndex = currentIndex
            }
        }

        val current = array[pointerIndex]
        array[pointerIndex] = array[smallestIndex]
        array[smallestIndex] = current
    }

}

fun main() {
    val array = arrayOf(1, 3, 4, 7, 5, 6, 8, 2)
    selectionSort(array)
    println(array.contentToString())
}