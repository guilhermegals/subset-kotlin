fun List<Int>.subsets(): List<List<Int>> {
    // Create the result with the empty subset "{}"
    val result = mutableListOf<MutableList<Int>>(mutableListOf())

    // Sort the current list to avoid problems with duplicate numbers
    val currentList = this.sorted()

    currentList.forEach { number ->
        // Create a copy of the result to update the list during the 'forEach'
        result.toList().forEach { subset ->

            // Create a copy of the current subset and add the current number to create a new subset group
            val newSubset = subset.toMutableList().apply {
                add(number)
            }

            // Check if this subset already exists
            if (!result.contains(newSubset))
                result.add(newSubset)
        }
    }

    return result
}