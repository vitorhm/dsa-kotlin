package bigO

object ConstantTime {

    private fun printFirst(array: Array<String>) {
        println(array[0])
    }

    @JvmStatic
    fun main(args: Array<String>) {

        val list = mutableListOf("first")
        repeat(100_000) { list.add("nemo") }

        printFirst(list.toTypedArray()) // O(1) --> Constant Time
    }
}