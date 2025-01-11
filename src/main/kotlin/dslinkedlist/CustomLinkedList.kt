package dslinkedlist

class CustomLinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    constructor(value: T) {
        val node = Node(value, null)
        head = node
        tail = head
    }

    constructor()

    fun append(value: T) {

        val node = Node(value, null)
        if (head == null) {
            head = node
        }

        tail?.let { it.next = node }
        tail = node
    }

    fun prepend(value: T) {

        val node = Node(value, this.head)
        head = node

        if (tail == null) tail = head
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
    list.append(5)
    list.prepend(20)

    println(list)
}