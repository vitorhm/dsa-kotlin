package algorithms.searching

import data.structures.trees.BinarySearchTree
import data.structures.trees.Node

fun BinarySearchTree.dfsInOrder(): List<Int> {
    if (root == null) return listOf()
    return dfsInOrder(root!!, mutableListOf())
}

fun BinarySearchTree.dfsPreOrder(): List<Int> {
    if (root == null) return listOf()
    return dfsPreOrder(root!!, mutableListOf())
}

fun BinarySearchTree.dfsPostOrder(): List<Int> {
    if (root == null) return listOf()
    return dfsPostOrder(root!!, mutableListOf())
}

fun dfsInOrder(node: Node, list: MutableList<Int>): List<Int> {

    if (node.left != null) dfsInOrder(node.left!!, list)

    list.add(node.value)

    if (node.right != null) dfsInOrder(node.right!!, list)

    return list
}

fun dfsPreOrder(node: Node, list: MutableList<Int>): List<Int> {

    list.add(node.value)

    if (node.left != null) dfsPreOrder(node.left!!, list)

    if (node.right != null) dfsPreOrder(node.right!!, list)

    return list
}

fun dfsPostOrder(node: Node, list: MutableList<Int>): List<Int> {

    if (node.left != null) dfsPostOrder(node.left!!, list)

    if (node.right != null) dfsPostOrder(node.right!!, list)

    list.add(node.value)

    return list
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

    println(bst.dfsInOrder())
    println(bst.dfsPreOrder())
    println(bst.dfsPostOrder())
}