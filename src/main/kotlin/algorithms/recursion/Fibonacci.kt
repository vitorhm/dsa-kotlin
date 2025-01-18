package algorithms.recursion

fun fibonacci(n: Int): Int {

    if (n < 2)
        return n

    return fibonacci(n - 1) + fibonacci(n - 2)
}

fun main() {

    println(fibonacci(4))
}