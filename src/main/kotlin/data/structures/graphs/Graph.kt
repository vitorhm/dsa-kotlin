package data.structures.graphs

class Graph {

    private val adjacentList = mutableMapOf<Int, MutableSet<Int>>()

    fun addVertex(node: Int) {
        adjacentList[node] = mutableSetOf()
    }

    fun addEdge(node: Int, node2: Int) {
        adjacentList[node]?.add(node2)
        adjacentList[node2]?.add(node)
    }

    fun showConnections() {

        for (node in adjacentList.keys) {
            print("$node -->")
            adjacentList[node]!!.forEach { print(" $it") }

            println()
        }

    }
}

fun main() {
    val graph = Graph()
    graph.addVertex(0)
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    graph.addVertex(5);
    graph.addVertex(6);

    graph.addEdge(3, 1);
    graph.addEdge(3, 4);
    graph.addEdge(4, 2);
    graph.addEdge(4, 5);
    graph.addEdge(1, 2);
    graph.addEdge(1, 0);
    graph.addEdge(0, 2);
    graph.addEdge(6, 5);

    graph.showConnections()
}