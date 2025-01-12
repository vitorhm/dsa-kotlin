package dsstackqueues

/**
 * Queue using stack
 */
class QueueWithStack<T> {

    private val a1 = mutableListOf<T>() // ()
    private val a2 = mutableListOf<T>() // ()

    /**
     * a1 -> (1) \ a2 -> ()
     * enqueue(2)
     *   a1 -> () \ a2 -> (1)
     *   a1 -> (2)
     *   a1 -> (2,1) \ a2 -> ()
     *
     * a1 -> (2,1) \ a2 -> ()
     * enqueue(3)
     *   a1 -> (2) \ a2 -> (1)
     *   a1 -> () \ a2 -> (1,2)
     *   a1 -> (3)
     *   a1 -> (3,2) \ a2 -> (1)
     *   a1 -> (3,2,1) \ a2 -> ()
     */

    fun enqueue(value: T) {

        while (a1.isNotEmpty()) {
            a2.add(a1.removeLast())
        }

        a1.add(value)

        while (a2.isNotEmpty()) {
            a1.add(a2.removeLast())
        }
    }

    fun dequeue(): T {

        return a1.removeLast()
    }

    fun peek(): T {

        return a1.last()
    }

    override fun toString(): String = a1.toString()

}

fun main() {

    val stack = QueueWithStack<Int>()
    stack.enqueue(1)
    println(stack)

    stack.enqueue(2)
    println(stack)

    stack.enqueue(3)
    println(stack)

    stack.dequeue()
    println(stack)

    assert(stack.peek() == 2)

    stack.dequeue()
    println(stack)

    stack.dequeue()
    println(stack)
}