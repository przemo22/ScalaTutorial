package `00`.homework

import scala.annotation.tailrec

object Recursion {



  // is up to your skills how u implement this method
  // should return only single value for params:
  // c - column
  // r - row
  //
  // pascal (1,2) = 2
  //
  //  1
  //  1 1
  //  1 2 1
  //  1 3 3 1
  //  1 4 6 4 1
  //  1 5 10 10 5 1
  //  1 6 15 20 15 6 1
  //  1 7 21 35 35 21 7 1
  //  1 8 28 56 70 56 28 8 1
  //  1 9 36 84 126 126 84 36 9 1
  //  1 10 45 120 210 252 210 120 45 10 1
  // todo: implement method
  def pascal(c: Int, r: Int): Int = ???


  // write in main function that print pascal triangle
  // using all available loops in scala
  // by using factorial(column, row) function without formatting triangle
  // todo: implement method
  def main(args: Array[String]): Unit =

    println("Print Pascal's Triangle")

    println


  //factorial should be tail recursive
  //uncomment below line with @tailrec annotation
  // todo: implement method
  //@tailrec
  def factorial(n: Int): Int = ???


}
