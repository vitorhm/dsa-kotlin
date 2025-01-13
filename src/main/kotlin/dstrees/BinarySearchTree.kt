package dstrees

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

    data class Node(
        var left: Node? = null,
        var right: Node? = null,
        val value: Int
    ) {

        override fun toString(): String = traverse(this)

        private fun traverse(root: Node?, prefix: String = "", isLeft: Boolean = true): String {

            var str: String

            if (root == null) {
                str = "$prefix${if (isLeft) "├──" else "└──"} null\n"
                return str
            }

            str = "$prefix${if (isLeft) "├──" else "└──"} ${root.value}\n"
            val childPrefix = "$prefix${if (isLeft) "│   " else "    "}"
            str += traverse(root.left, childPrefix, true)
            str += traverse(root.right, childPrefix, false)

            return str
        }
    }
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

    println(binarySearchTree.lookup(5))
}