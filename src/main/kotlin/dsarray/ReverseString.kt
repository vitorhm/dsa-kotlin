package dsarray

object ReverseString {

    fun reverse(str: String): String = str.reversed() // Too easy :)

    fun reverse2(str: String): String {
        return str
            .mapIndexed { index, c -> str[(str.length - 1) - index] }
            .joinToString("")
    }

    @JvmStatic
    fun main(args: Array<String>) {

        println(reverse("ABC"))
        println(reverse2("ABC"))
    }

}