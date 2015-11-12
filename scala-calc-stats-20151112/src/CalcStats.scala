/**
 * Created by paulo on 12/11/2015.
 */
class CalcStats {

  def process(numbers: Array[Double]): Array[Double] = {
    val min = numbers.reduce(minVal)
    val max = numbers.reduce(maxVal)

    return Array(min, max)
  }

  def minVal(prev: Double, actual: Double): Double = {
    if (prev < actual) prev else actual
  }

  def maxVal(prev: Double, actual: Double): Double = {
    if (prev > actual) prev else actual
  }

}
