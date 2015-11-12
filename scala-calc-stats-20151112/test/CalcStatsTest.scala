import org.scalatest.FunSpec

class CalcStatsTest extends FunSpec {

  describe("process()") {

    it("should determine minimum value in the sequence") {
      val numbers = Array[Double](2, 8, 1, 5)

      val stats = CalcStats.process(numbers)

      assert(stats.minimum === 1)
    }

    it("should determine maximum value in the sequence") {
      val numbers = Array[Double](2, 8, 1, 5)

      val stats = CalcStats.process(numbers)

      assert(stats.maximum === 8)
    }

    it("should determine the number of elements in the sequence") {
      val numbers = Array[Double](1, 2, 3)

      val stats = CalcStats.process(numbers)

      assert(stats.numElements === 3)
    }

    it("should determine the average value in the sequence") {
      val numbers = Array[Double](0, 4, 6)

      val stats = CalcStats.process(numbers)

      assert(stats.average === 5)
    }
  }

}
