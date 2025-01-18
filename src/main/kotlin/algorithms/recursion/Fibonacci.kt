package algorithms.recursion

fun fibonacci(n: Int): Int {

    if (n < 2)
        return n

    return fibonacci(n - 1) + fibonacci(n - 2)
}

fun fibonacciIterative(n: Int): Int {

    if (n < 2) return n

    var n1 = 0
    var n2 = 1
    var current = 0

    for (i in 2..n) {

        current = n1 + n2
        n1 = n2
        n2 = current
    }

    return current
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
}

fun main() {

    println(fibonacci(5))
    println(fibonacciIterative(5))
}