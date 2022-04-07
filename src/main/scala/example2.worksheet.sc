import scala.annotation.tailrec
import scala.util.Random

sealed trait RNG {
  def nextInt: (Int, RNG)
  def nonNegativeInt(rng: RNG): (Int, RNG)
}
case class SimpleRNG(seed: Long) extends RNG {
  override def nextInt: (Int, RNG) = {
    val newSeed = ( seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
    val nextRNG = SimpleRNG(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRNG)
  }

  override def nonNegativeInt(rng: RNG): (Int, RNG) = {
    @tailrec
    def go(rng: RNG, value: Int): (Int, RNG) = {
      val a = rng.nextInt
      val currentValue: Int = a._1
      if ( currentValue <= (Int.MaxValue+1)  && currentValue >= -1 ) {
        (currentValue, a._2)
      } else{
        go(a._2, currentValue)
      }
    }
    go(rng, 0)

  }
}



val asd = SimpleRNG(1)
val c = asd.nextInt
c._1
c._2
print(asd.nonNegativeInt(SimpleRNG(22222)))

asd.toString
