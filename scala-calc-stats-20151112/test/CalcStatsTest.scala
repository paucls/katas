import org.scalatest.FunSpec

class CalcStatsTest extends FunSpec {

  describe("process()") {

    it("should determine minimum value in the sequence") {
      val numbers = Array[Double](2, 8, 1, 5)

      val stats = CalcStats.process(numbers)

      assert(stats(0) === 1)
    }

    it("should determine maximum value in the sequence") {
      val numbers = Array[Double](2, 8, 1, 5)

      val stats = CalcStats.process(numbers)

      assert(stats(1) === 8)
    }

  }

}
