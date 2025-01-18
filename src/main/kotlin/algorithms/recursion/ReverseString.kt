package algorithms.recursion

fun reverse(str: String): String {
    if (str.isEmpty()) return ""
    return reverse(str.substring(1)) + str.elementAt(0)
}

fun main() {
    println(reverse("ABC"))
}