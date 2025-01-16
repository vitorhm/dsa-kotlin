package dstrees

data class Node(
    var left: Node? = null,
    var right: Node? = null,
    var value: Int
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
