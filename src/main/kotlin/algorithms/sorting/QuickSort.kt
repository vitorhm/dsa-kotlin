package algorithms.sorting

fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        // Partition the array and get the pivot index
        val pi = partition(arr, low, high)

        // Recursively sort the elements before and after the partition
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    // Choose the last element as the pivot
    val pivot = arr[high]
    var i = low - 1 // Index of smaller element

    // Traverse the array from 'low' to 'high - 1'
    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            // Swap arr[i] and arr[j]
            arr.swap(i, j)
        }
    }
    // Place the pivot in its correct position
    arr.swap(i + 1, high)
    return i + 1
}

// Helper function to swap elements in the array
fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun main() {
    val array = intArrayOf(10, 7, 8, 9, 1, 5)
    println(array.contentToString())
    quickSort(array, 0, array.size - 1)
    println(array.contentToString())
}
