import org.scalatest.FunSpec

class CalcStatsTest extends FunSpec {

  describe("process()") {

    val numbers = Array[Double](2, 8, -2, 5, 3)

    it("should determine minimum value in the sequence") {
      val stats = CalcStats.process(numbers)

      assert(stats.minimum === -2)
    }

    it("should determine maximum value in the sequence") {
      val stats = CalcStats.process(numbers)

      assert(stats.maximum === 8)
    }

    it("should determine the number of elements in the sequence") {
      val stats = CalcStats.process(numbers)

      assert(stats.numElements === 5)
    }

    it("should determine the average value in the sequence") {
      val stats = CalcStats.process(numbers)

      assert(stats.average === 3.2)
    }
  }

}
