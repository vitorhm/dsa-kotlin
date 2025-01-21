## Exercise

## Which algorithm should you use? BFS or DFS?

### If you know a solution is not far from the root of the tree
BFS because we transverse from left to right, starting on the root.

### If the tree is very deep and solutions are rare
BFS (DFS will take a long time)

### If the tree is very wide
DFS (BFS will need too much memory)

### If solutions are frequent but located deep in the tree
DFS because we go first on the bottom.

### Determining whether a path exists between two nodes:
DFS

### Finding the shortest path:
BFS
