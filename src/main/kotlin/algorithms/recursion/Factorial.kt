package algorithms.recursion

fun factorial(n: Int): Int {
    if (n == 1) return n
    return n * factorial(n - 1)
}

fun factorialIterative(n: Int): Int {
    var sum = n
    for (i in n - 1 downTo 1) {
        sum += sum * (i - 1)
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