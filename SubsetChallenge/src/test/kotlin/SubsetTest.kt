import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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