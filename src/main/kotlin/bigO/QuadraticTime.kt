package bigO

object QuadraticTime {

    val array = arrayOf(1, 2, 3, 4, 5)

    @JvmStatic
    fun main(args: Array<String>) {

        for (i in array) {
            for (x in array) {
                println("$i$x")
            }
        }

    }
}