package data.structures.trees

class BinarySearchTree {

    private var root: Node? = null

    fun insert(value: Int) {

        val node = Node(value = value)

        if (root == null) {
            root = node
            return
        }

        insert(child = node, parent = root!!)
    }

    fun remove(value: Int): Node? = remove(root, value)

    /**
     *        30
     *      18  40
     *    14 25
     */

    private fun remove(node: Node?, value: Int): Node? {

        if (node == null) return null

        when {
            value > node.value -> {
                node.right = remove(node.right, value)
            }

            value < node.value -> {
                node.left = remove(node.left, value)
            }

            else -> {
                // 3 cases

                // left and right are null (leaf)
                if (node.right == null && node.left == null) return null

                // left or right are null
                if (node.right == null) return node.left
                if (node.left == null) return node.right

                // left and right aren't null
                val new = findMin(node.right!!)
                node.value = new.value
                node.right = remove(node.right, new.value)
            }
        }

        return node
    }

    private fun findMin(node: Node): Node {
        var current: Node = node
        while (current.left != null) {
            current = current.left!!
        }

        return current
    }

    private fun insert(child: Node, parent: Node) {

        return if (child.value > parent.value) {
            if (parent.right == null) {
                parent.right = child
                return
            }
            insert(child, parent.right!!)
        }
        else {
            if (parent.left == null) {
                parent.left = child
                return
            }
            insert(child, parent.left!!)
        }
    }

    private fun lookup(node: Node?, value: Int): Node? {

        if (node == null) return null
        if (node.value == value) return node

        return if (value > node.value) {
            lookup(node.right, value)
        } else {
            lookup(node.left, value)
        }
    }

    fun lookup(value: Int) = lookup(root, value)

    override fun toString(): String = root.toString()
}

fun main() {

    val binarySearchTree = BinarySearchTree()
    binarySearchTree.insert(10)
    binarySearchTree.insert(20)
    binarySearchTree.insert(5)
    binarySearchTree.insert(4)
    binarySearchTree.insert(6)
    binarySearchTree.insert(3)

    println(binarySearchTree)

//    println(binarySearchTree.lookup(5))

    println(binarySearchTree.remove(5))
}