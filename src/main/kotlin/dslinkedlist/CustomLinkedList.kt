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

    private fun findNode(index: Int): Node<T>? {

        var node: Node<T>? = head
        var counter = 0

        while (counter != index && node != null) {
            node = node.next
            ++counter
        }

        return node
    }

    fun insert(index: Int, value: T) {

        if (index == 0) {
            prepend(value)
            return
        }

        val lead = findNode(index - 1)
        if (lead == null) {
            append(value)
            return
        }

        val newNode = Node(value, lead.next)
        lead.next = newNode
    }

    override fun toString(): String {
        var node = head
        var string = ""
        while (node != null) {
            string += node.value
            node = node.next
            node?.let { string += "," }
        }

        return string
    }

    data class Node<T>(
        val value: T,
        var next: Node<T>?
    )

}

fun main() {
    val list = CustomLinkedList(1)
    println(list)
    list.append(2)
    println(list)
    list.prepend(5)
    println(list)
    list.insert(2, 60)
    println(list)
    list.insert(50, 30)
    println(list)
    list.insert(0, 80)
    println(list)
}