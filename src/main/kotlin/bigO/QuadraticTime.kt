package bigO

val array = arrayOf(1, 2, 3, 4, 5)

fun main() {

    for (i in array) {
        for (x in array) {
            println("$i$x")
        }
    }

}