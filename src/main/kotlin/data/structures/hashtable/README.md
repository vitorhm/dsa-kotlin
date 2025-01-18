## HashTables

### Advantages

- **Fast lookups****: Lookup by key -> O(1)
- **Fast inserts**: O(1)
- **Flexible Keys**

** With good collision resolution. If we don't have collision, the lookup is O(1) and with collision it's O(n).

### Disadvantages

- **Unordered**: Unlike array, the items are not ordered, because the location depends on the hashed key
- **Slow key iteration**: If you need all the keys, then we have to loop through the entire memory space