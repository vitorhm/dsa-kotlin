package algorithms.searching

import data.structures.stack.queues.QueueWithLinkedList
import data.structures.trees.BinarySearchTree
import data.structures.trees.Node

fun BinarySearchTree.breadthFirstSearch(value: Int): Node? {
    var currentNode = root
    val queue = QueueWithLinkedList<Node>()

    while (currentNode != null) {

        if (currentNode.value == value) return currentNode

        val left = currentNode.left

        if (left != null) {
            queue.enqueue(left)
        }

        val right = currentNode.right

        if (right != null) {
            queue.enqueue(right)
        }

        currentNode = queue.dequeue()
    }

    return null
}

fun BinarySearchTree.breadthFirstSearchRecursive(queue: QueueWithLinkedList<Node>, value: Int): Node? {

    val node = queue.dequeue() ?: return null
    println(node.value)

    if (node.value == value) return node

    if (node.left != null) queue.enqueue(node.left!!)
    if (node.right != null) queue.enqueue(node.right!!)

    return breadthFirstSearchRecursive(queue, value)
}

fun main() {

    val bst = BinarySearchTree()
    bst.insert(10)
    bst.insert(5)
    bst.insert(20)
    bst.insert(3)
    bst.insert(7)
    bst.insert(18)
    bst.insert(23)

    println(bst.toString())

    val node = bst.breadthFirstSearch(23)
    println(node)

    val queue = QueueWithLinkedList<Node>()
    queue.enqueue(bst.root!!)
    bst.breadthFirstSearchRecursive(queue, 23)

}