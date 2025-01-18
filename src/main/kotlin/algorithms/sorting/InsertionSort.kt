package algorithms.sorting

fun insertionSort(arr: IntArray): IntArray {

    for (i in arr.indices) {
        val key = arr[i]
        var j = i - 1

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            --j
        }

        arr[j + 1] = key
        println(arr.contentToString())
    }

    return arr
}

fun main() {
    val array = intArrayOf(3, 1, 4, 7, 5, 6, 8, 2)
    insertionSort(array)
}