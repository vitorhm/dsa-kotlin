package dsstackqueues

/**
 * Queue using stack.
 * Enqueue operation --> O(1)
 * Dequeue operation --> O(1) and the worst case is O(n)
 */
class QueueWithStack2<T> {

    private val a1 = mutableListOf<T>()
    private val a2 = mutableListOf<T>()
    private var top: T? = null

    fun enqueue(value: T) {
        a1.add(value)
    }

    fun dequeue(): T {

        // Worst case is O(n)
        if (a2.isEmpty()) {
            while (a1.isNotEmpty()) {
                a2.add(a1.removeLast())
            }
        }

        /**
         * Using Amortized Analysis, we can deduce that worst case operation may alter the state and cannot happen again
         * for a long time.
         *
         * For example:
         *  enqueue(x) -> enqueue(x) -> enqueue(x) -> enqueue(x) -> enqueue(x) -> enqueue(x)
         *  dequeue() -> dequeue() -> dequeue() -> dequeue()
         *
         * In this case, only the first dequeue is gonna be O(n), while all the others will be O(1)
         */
        return a2.removeLast()
    }

    fun peek(): T? {
        return if (a2.isNotEmpty()) a2.last() else a1.first()
    }

    override fun toString(): String = (a2 + a1).toString()
}

/*
    a1 = (1, 2, 3) \ a2 = ()
    dequeue()
        a1 = (1, 2) \ a2 = (3)
        a1 = (1) \ a2 = (3, 2)
        a1 = () \ a2 = (3, 2, 1)
        a1 = () \ a2 = (3, 2)
    enqueue(10)
        a1 = (10) \ a2 = (3, 2)
 */

fun main() {

    val stack = QueueWithStack2<Int>()
    stack.enqueue(1)
    println(stack)

    stack.enqueue(2)
    println(stack)

    stack.enqueue(3)
    println(stack)

    stack.dequeue()
    println(stack)

    assert(stack.peek() == 2)

    stack.enqueue(10)
    println(stack)

    stack.dequeue()
    println(stack)

    stack.enqueue(20)
    println(stack)

    stack.dequeue()
    println(stack)
}