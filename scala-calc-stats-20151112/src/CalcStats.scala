object CalcStats {

  def process(numbers: Array[Double]): Stats = {
    val min = numbers.reduce(minVal)
    val max = numbers.reduce(maxVal)
    val average = numbers.reduce(avgVal)

    return new Stats(min, max, numbers.length, average)
  }

  def minVal(prev: Double, actual: Double): Double = {
    if (prev < actual) prev else actual
  }

  def maxVal(prev: Double, actual: Double): Double = {
    if (prev > actual) prev else actual
  }

  def avgVal(x: Double, y: Double): Double = {
    x + y / 2
  }

}

class Stats(val minimum:Double, val maximum:Double, val numElements:Int, val average: Double)

