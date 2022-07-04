# Subset challenge in Kotlin

## Summary

The project was developed in Kotlin using the IDE IntelliJ.

To run locally you must install the Kotlin SDK and JVM.

You can run the project using the [Kotlin Playground](https://pl.kotl.in/70D4xOwWe).

---

## Code

Subset function ([Subset.kt](https://github.com/guilhermegals/subset-kotlin/blob/main/SubsetChallenge/src/main/kotlin/Subset.kt)):

``` Kotlin
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
```

Main function ([Main.kt](https://github.com/guilhermegals/subset-kotlin/blob/main/SubsetChallenge/src/main/kotlin/Main.kt)):

``` Kotlin
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
```

Testcase class ([SubsetTest.kt](https://github.com/guilhermegals/subset-kotlin/blob/main/SubsetChallenge/src/test/kotlin/SubsetTest.kt))

``` Kotlin

class SubsetTest {

    @Test
    fun `Empty collection should has one subset`() {
        val expectedResult = 1

        val list = listOf<Int>()
        val result = list.subsets()

        assertEquals(expectedResult, result.size)
    }

    @Test
    fun `Empty collection should has an empty subset`() {
        val expectedResult = mutableListOf(mutableListOf<Int>())

        val list = listOf<Int>()
        val result = list.subsets()

        assertEquals(expectedResult, result)
    }

    @Test
    fun `Non duplicate collection should has a valid quantity of subsets`() {
        val expectedResult = 8

        val list = listOf(1, 2, 3)
        val result = list.subsets()

        assertEquals(expectedResult, result.size)
    }

    @Test
    fun `Non duplicate collection should has valid subsets`() {
        val expectedResult = mutableListOf(
            mutableListOf(),
            mutableListOf(1),
            mutableListOf(2),
            mutableListOf(3),
            mutableListOf(1, 2),
            mutableListOf(1, 3),
            mutableListOf(2, 3),
            mutableListOf(1, 2, 3)
        )

        val list = listOf(1, 3, 2)
        val result = list.subsets().sortedWith(compareBy<List<Int>> { it.size }.thenBy { it.sum() })

        var count = 0
        for (index in expectedResult.indices) {
            if (expectedResult[index].sum() == result[index].sum()) count++
        }
        assertEquals(expectedResult.size, count)
    }

    @Test
    fun `Duplicate collection should has a valid quantity of subsets`() {
        val expectedResult = 12

        val list = listOf(1, 2, 2, 3)
        val result = list.subsets()

        assertEquals(expectedResult, result.size)
    }

    @Test
    fun `Duplicate collection should has a valid subsets`() {
        val expectedResult = mutableListOf(
            mutableListOf(),
            mutableListOf(1),
            mutableListOf(2),
            mutableListOf(3),
            mutableListOf(1, 2),
            mutableListOf(1, 3),
            mutableListOf(2, 2),
            mutableListOf(2, 3),
            mutableListOf(1, 2, 2),
            mutableListOf(1, 2, 3),
            mutableListOf(2, 2, 3),
            mutableListOf(1, 2, 2, 3),
        )

        val list = listOf(1, 2, 3, 2)
        val result = list.subsets().sortedWith(compareBy<List<Int>> { it.size }.thenBy { it.sum() })

        println(result)
        println(expectedResult)

        var count = 0
        for (index in expectedResult.indices) {
            if (expectedResult[index].sum() == result[index].sum()) count++
        }
        assertEquals(expectedResult.size, count)
    }
}

```
