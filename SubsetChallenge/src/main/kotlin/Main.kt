fun main(args: Array<String>) {
    println("Examples of subsets!\n")
    listOf(
        listOf(1, 2),
        listOf(1, 3, 2),
        listOf(1, 2, 2),
        listOf(1, 2, 3, 4),
        listOf(1, 2, 4, 2),
    ).forEach { testCase ->
        printSubset(testCase, testCase.subsets())
    }

    println("\n\nNow try yourself!\nType a list of integers, e.g. '1 2 3'")
    val readLine = readLine()
    readLine?.let { line ->
        val numbers = line.trimEnd().split(" ").map { it.toInt() }.toList()
        val result = numbers.subsets()
        printSubset(numbers, result)
    }
}

fun printSubset(collection: List<Int>, subsets: List<List<Int>>) {
    println("Collection: $collection")
    println("Collection's Subsets: $subsets")
    println("Quantity of subsets: ${subsets.size}\n")
}
