package dshashtable

class CustomHashTable<T>(private val size: Int) {

    private val array: Array<MutableList<List<Any>>?> = arrayOfNulls(size)

    private fun hash(key: String): Int {
        var hash = 0
        for (i in key.indices) {
            hash += (key[i].code * i) % this.array.size
        }

        return hash
    }

    fun set(key: String, value: T) {

        val hash = hash(key)
        val bucket = array[hash]

        if (bucket != null) {
            bucket.add(listOf(key, value!!))
        } else {
            array[hash] = mutableListOf(listOf(key, value!!))
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun get(key: String): T? {

        val hash = hash(key)
        val bucket = array[hash]

        if (bucket != null) {
            for (i in bucket.indices) {
                if (bucket[i][0] == key) {
                    return bucket[i][1] as T
                }
            }
        }

        return null
    }

    fun keys(): List<String> {
        val list = mutableListOf<String>()

        for (i in this.array) {
            if (i != null) {
                list.add(i[0][0].toString())
            }
        }

        return list.toList()
    }

}

fun main() {

    val hashTable = CustomHashTable<Int>(30)
    hashTable.set("abc", 10)

    println(hashTable.get("abc"))
    println(hashTable.get("cdb"))
    println(hashTable.keys())
}