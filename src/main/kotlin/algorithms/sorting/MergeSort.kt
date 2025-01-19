package algorithms.sorting

fun mergeSort(arr: IntArray): IntArray {

    if (arr.size == 1) return arr

    val middle = arr.size / 2
    val left = arr.sliceArray(0 until middle)
    val right = arr.sliceArray(middle until arr.size)

    return merge(
        mergeSort(left),
        mergeSort(right)
    )
}

fun merge(left: IntArray, right: IntArray): IntArray {

    val arr = IntArray(left.size + right.size)
    var mergedIndex = 0
    var leftIndex = 0
    var rightIndex = 0

    while (leftIndex < left.size && rightIndex < right.size) {

        if (left[leftIndex] < right[rightIndex]) {
            arr[mergedIndex++] = left[leftIndex++]
            continue
        }

        arr[mergedIndex++] = right[rightIndex++]
    }

    while (leftIndex < left.size) {
        arr[mergedIndex++] = left[leftIndex++]
    }

    while (rightIndex < right.size) {
        arr[mergedIndex++] = right[rightIndex++]
    }

    return arr
}

fun main() {
    val array = intArrayOf(3, 1, 4, 7, 5, 6, 8, 2)
    val sorted = mergeSort(array)
    println(sorted.contentToString())
}