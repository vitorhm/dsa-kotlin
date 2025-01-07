package htscp

object GoogleInterview {

    @JvmStatic
    fun main(args: Array<String>) {

        // Find the first pair inside the array that is equal to the informed sum

        val arr = listOf(1, 2, 4, 4) // In this case --> 4 + 4 = 8

        println(naiveSolution(arr, 8))
        println(betterSolution(arr, 8))
    }

    private fun naiveSolution(arr: List<Int>, sum: Int): Boolean {

        // First solution in mind
        // O(n²)
        for (i in arr) {
            for (x in arr) {
                if (i + x == sum) return true
            }
        }

        return false
    }

    private fun betterSolution(arr: List<Int>, sum: Int): Boolean {

        // Much better approach
        // O(n + 1) --> O(n)
        val set = HashSet<Int>()
        for (i in arr) { // O(n)
            if (set.contains(i)) return true // O(1)

            set.add(sum - i)
        }

        return false
    }

}