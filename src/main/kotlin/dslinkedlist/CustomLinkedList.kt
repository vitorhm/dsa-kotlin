package dslinkedlist

class CustomLinkedList<T>(value: T) {

    private var head: Node<T>
    private var tail: Node<T>

    init {
        val node = Node(value, null)
        head = node
        tail = head
    }

    fun append(value: T) {

        val node = Node(value, null)
        tail.next = node
        tail = node
    }

    override fun toString(): String {
        return "Head: $head | Tail: $tail"
    }

    data class Node<T>(
        val value: T,
        var next: Node<T>?
    )

}

fun main() {
    val list = CustomLinkedList(1)
    list.append(2)

    println(list)
}