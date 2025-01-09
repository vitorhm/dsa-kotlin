package bigO

import java.time.Instant

private fun find(array: Array<String>) {
    val t0 = Instant.now()
    for (i in array) {
        if (i == "nemo") {
            println("found nemo")
        }
    }
    val t1 = Instant.now()

    println("Took ${t1.toEpochMilli() - t0.toEpochMilli()}ms")
}

fun main() {

    val list = mutableListOf("")
    repeat(100_000) { list.add("nemo") }

    find(list.toTypedArray()) // O(n) --> Linear Time
}