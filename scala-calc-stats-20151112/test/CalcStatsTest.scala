import org.scalatest.FunSpec

class CalcStatsTest extends FunSpec {

  describe("process()") {

    it("should identify minimum value for an array with one value") {
      val calcStats = new CalcStats
      val numbers = Array[Double](2)

      val results = calcStats.process(numbers)

      assert(results === Array(2, 2))
    }

    it("should identify minimum value in an array of multiple values") {
      val calcStats = new CalcStats
      val numbers = Array[Double](2, 8, 1, 5)

      val results = calcStats.process(numbers)

      assert(results === Array(1, 8))
    }

    it("should identify the maximum value in a list of numbers") {
      val calcStats = new CalcStats
      val numbers = Array[Double](2, 8, 3, 5)

      val results = calcStats.process(numbers)

      assert(results === Array(2, 8))
    }

  }

}
