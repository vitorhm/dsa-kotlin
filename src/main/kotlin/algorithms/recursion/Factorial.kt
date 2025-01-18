package algorithms.recursion

fun factorial(n: Int): Int {
    if (n == 1) return n
    return n * factorial(n - 1)
}

fun main() {
    val fact = factorial(3)
    println(fact)
}