object CalcStats {

  def process(numbers: Array[Double]): Stats = {
    val minimum = numbers.reduce(min)
    val maximum = numbers.reduce(max)
    val numElements = numbers.length
    val average = numbers.reduce(sum) / numElements

    return new Stats(minimum, maximum, numElements, average)
  }

  def min(prev: Double, actual: Double): Double = {
    if (prev < actual) prev else actual
  }

  def max(prev: Double, actual: Double): Double = {
    if (prev > actual) prev else actual
  }

  def sum(x: Double, y: Double): Double = {
    x + y
  }

}

class Stats(val minimum:Double, val maximum:Double, val numElements:Int, val average: Double)

