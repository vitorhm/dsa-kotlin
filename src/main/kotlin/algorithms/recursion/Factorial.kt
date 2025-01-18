package algorithms.recursion

fun factorial(n: Int): Int {
    if (n == 1) return n
    return n * factorial(n - 1)
}

fun factorialIterative(n: Int): Int {

    if (n == 0) return 1

    var sum = n
    var c = n
    while (c > 1) {
        sum *= c - 1
        --c
    }

    return sum
}

fun main() {
    val fact = factorial(5)
    println(fact)

    val iterative = factorialIterative(5)
    println(iterative)

    assert(fact == iterative)
}