object CalcStats {

  def process(numbers: Array[Double]): Array[Double] = {
    val min = numbers.reduce(minVal)
    val max = numbers.reduce(maxVal)
    val numElements = numbers.length

    return Array(min, max, numElements)
  }

  def minVal(prev: Double, actual: Double): Double = {
    if (prev < actual) prev else actual
  }

  def maxVal(prev: Double, actual: Double): Double = {
    if (prev > actual) prev else actual
  }

}
