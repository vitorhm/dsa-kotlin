package data.structures.stack.queues

class StackWithLinkedList<T>() {

    private var top: Node<T>? = null
    private var bottom: Node<T>? = null

    fun peek(): T? {
        return top?.value
    }

    fun push(value: T) {
        val node = Node(value, top)
        top = node
        if (bottom == null) bottom = top
    }

    fun pop() {
        val newHead = top?.next
        top = newHead
        if (top == null) bottom = null
    }

    fun isEmpty(): Boolean {
        return top == null
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "empty"
        }

        var node = top
        var string = ""
        while (node != null) {
            string += node.value
            node = node.next
            node?.let { string += "," }
        }

        return "$string (top: ${top?.value} | bottom: ${bottom?.value})"
    }

    data class Node<T>(
        val value: T,
        var next: Node<T>?
    )

}

fun main() {

    val stack = StackWithLinkedList<Int>()
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