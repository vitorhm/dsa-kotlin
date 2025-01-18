package algorithms.recursion

fun factorial(n: Int, sum: Int): Int {
    if (n == 1) return sum
    val s = if (sum > 0) sum * (n - 1) else n * (n - 1)
    return factorial(n - 1, s)
}

//fun factorial(n: Int, sum: Int): Int {
//    if (n == 1) return sum
//    val s = n * sum
//    return factorial(n - 1, s)
//}
//
//fun factorial(n: Int): Int {
//    val sum = n * (n - 1)
//    return factorial(n - 2, sum)
//}

fun main() {
    val fact = factorial(5, 0)
    println(fact)
}