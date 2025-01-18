package data.structures.linked.list

/**
 * This is a custom implementation of a linked list
 *
 * Each node points to next node, and we have a head that points to the first node and
 * a tail that points to the last node.
 */
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

    fun remove(index: Int) {

        if (index == 0) {

            head = head?.next
            if (head == null) tail = null

            return
        }

        // Find the lead
        val lead = findNode(index - 1)

        // Get the current item on this index (which is the next node on the lead)
        val deleted = lead?.next

        // Point the next node of the lead to the next node of the deleted (erasing all references to the deleted node)
        lead?.next = deleted?.next
        if (tail == deleted) tail = lead
    }

    fun reverse() {

        var previous = head
        var current = previous?.next
        tail = head

        while (current != null) { // 3
            val next = current.next // 4
            current.next = previous // 4 --> 2
            previous = current // 3
            current = next // 4
        }

        tail?.next = null
        head = previous
    }

    fun recursiveReverse() {

        tail = head
        head = reverseHead(head)
    }

    private fun reverseHead(head: Node<T>?): Node<T>? {

        if (head?.next == null) {
            return head
        }

        val reversed = reverseHead(head.next) // 3
        head.next?.next = head
        head.next = null

        return reversed
    }

    override fun toString(): String {
        var node = head
        var string = ""
        while (node != null) {
            string += node.value
            node = node.next
            node?.let { string += "," }
        }

        return "$string (head: ${head?.value} | tail: ${tail?.value})"
    }

    data class Node<T>(
        val value: T,
        var next: Node<T>?
    )

}

fun main() {
    val list = CustomLinkedList(1)
    println(list)
    println("append(2)")
    list.append(2)
    println(list)
    println("prepend(5)")
    list.prepend(5)
    println(list)
    println("insert(2, 60)")
    list.insert(2, 60) // Middle
    println(list)
    println("insert(50, 30)")
    list.insert(50, 30) // Index too big (should append)
    println(list)
    println("insert(0, 80)")
    list.insert(0, 80) // Begin (should prepend)
    println(list)
    println("remove(0)")
    list.remove(0) // Begin (should update the head)
    println(list)
    println("remove(4)")
    list.remove(4) // End (should update the tail)
    println(list)
    println("remove(1)")
    list.remove(1) // Middle
    println(list)

    println("recursiveReverse()")
    list.recursiveReverse()
    println(list)

    println("reverse()")
    list.reverse()
    println(list)
}