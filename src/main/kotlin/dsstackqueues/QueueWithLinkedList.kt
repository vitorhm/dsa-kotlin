package dsstackqueues

class QueueWithLinkedList<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null

    fun peek(): T? {
        return first?.value
    }

    fun enqueue(value: T) {
        val node = Node(value, null)
        last?.next = node
        last = node
        if (first == null) first = last
    }

    fun dequeue(): T? {
        val next = first?.next
        val value = first?.value

        first = next
        if (first?.next == null) last = first

        return value
    }

    fun isEmpty(): Boolean {
        return first == null
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "empty (top: ${first?.value} | bottom: ${last?.value})"
        }

        var node = first
        var string = ""
        while (node != null) {
            string += node.value
            node = node.next
            node?.let { string += "," }
        }

        return "$string (top: ${first?.value} | bottom: ${last?.value})"
    }

    data class Node<T>(
        val value: T,
        var next: Node<T>?
    )

}

fun main() {

    val stack = QueueWithLinkedList<Int>()
    stack.enqueue(1)
    println(stack)

    stack.enqueue(2)
    println(stack)

    stack.enqueue(3)
    println(stack)

    stack.dequeue()
    println(stack)

    assert(stack.peek() == 2)
    assert(!stack.isEmpty())

    stack.dequeue()
    println(stack)

    stack.dequeue()
    println(stack)

    assert(stack.isEmpty())
}