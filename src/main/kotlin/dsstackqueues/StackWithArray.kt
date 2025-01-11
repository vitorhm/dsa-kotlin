package dsstackqueues

class StackWithArray<T> {

    private val internal = mutableListOf<T>()

    fun peek(): T? = internal.last()

    fun push(value: T) {
        internal.add(value)
    }

    fun pop() {
        internal.removeLast()
    }

    fun isEmpty(): Boolean = internal.isEmpty()

    override fun toString() = internal.toString()

}

fun main() {

    val stack = StackWithArray<Int>()
    stack.push(1)
    println(stack)

    stack.push(2)
    println(stack)

    stack.push(3)
    println(stack)

    stack.pop()
    println(stack)

    assert(stack.peek() == 2)
    assert(!stack.isEmpty())

    stack.pop()
    println(stack)

    stack.pop()
    println(stack)

    assert(stack.isEmpty())
}