package dslinkedlist

/**
 * This is a custom implementation of a doubly linked list
 *
 * Each node have a reference to next and previous node, and we have a head that holds a reference to the first node
 * and a tail that holds a reference to the last node.
 */
class CustomDoublyLinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    constructor(value: T) {
        val node = Node(value, null, null)
        head = node
        tail = head
    }

    constructor()

    fun append(value: T) {

        // Create the new node and set the previous reference to the tail node
        val node = Node(value, null, tail)

        // Set the head to this the node if this is our first
        if (head == null) {
            head = node
        }

        // If the current tail is not null then we set the next reference to this new node
        tail?.let { it.next = node }

        // Finally we set the tail to this node
        tail = node
    }

    fun prepend(value: T) {

        // Create the new node
        val node = Node(value, this.head, null)

        // If head is different then null (we have at least one node), we point the previous reference to this new node
        head?.previous = node

        // Set the head node to this new node
        head = node

        // Set the tail to this new head (only if this is our first node)
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

        // If index is equal zero then we prepend the value
        if (index == 0) {
            prepend(value)
            return
        }

        // Find the lead node
        val lead = findNode(index - 1)

        // If lead is equal null then we append the value
        if (lead == null) {
            append(value)
            return
        }

        // (lead) - (next)
        //     \     /
        //      (new)

        // Create the new node pointing the next reference to the lead next reference and the previous reference to the lead
        val new = Node(value, lead.next, lead)

        // Point the previous reference of the lead next node to the new node
        val next = lead.next
        next?.previous = new

        // Point the next reference of the lead to the new node
        lead.next = new
    }

    fun remove(index: Int) {

        if (index == 0) {

            head = head?.next
            if (head == null) tail = null

            return
        }

        // Find the lead
        val lead = findNode(index - 1)

        // (lead) - (next)
        //     \     /
        //     (deleted)

        // Get the current item on this index (which is the next node on the lead)
        val deleted = lead?.next

        // Get the next node of the deleted node
        val next = deleted?.next

        // Point the next node of the lead to the next node of the deleted
        lead?.next = next

        // Point the previous node of the next node to the lead
        next?.previous = lead

        if (tail == deleted) tail = lead
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
        var next: Node<T>?,
        var previous: Node<T>?
    )

}

fun main() {
    val list = CustomDoublyLinkedList(1)
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
}