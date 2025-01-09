package bigO

private fun printFirst(array: Array<String>) {
    println(array[0])
}

fun main() {

    val list = mutableListOf("first")
    repeat(100_000) { list.add("nemo") }

    printFirst(list.toTypedArray()) // O(1) --> Constant Time
}