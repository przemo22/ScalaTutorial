import scala.annotation.tailrec


//pure function is
//referential transparency!!
val x: String = "Scala , Tut"
val s1: String = x.reverse
val s2 = x.reverse

val e1 =  "Scala , Tut".reverse
val e2 =  "Scala , Tut".reverse

// not pure function
// not-referential transparency
val t = new StringBuilder("Hello")
val t1 = t.append(" , Tut")
val t2 = t.append(" , Tut")

// Trait is equivalent to Java/Js interface
// B :< A // B extends A
// B :> A // B is supertype of A

// covariance
// + means output type
// example=>  B:<A
// List[B] :< List[A]
// val list: List[A] = List[B](some, some1, some2)
// list.toString() knows how to print List[B]
// and list.ToString() knows how to print any type of A subtype
trait List[+A] {

  def tail: List[A]
  def head: A
  def toString(): String
}

// contravariance
// - means input type
// example => B :> A
// but MyList[B] :< MyList[A]
// val list: MyList[A] = List[B](some, some1, some2)
// list.ToString() knows how to print list[B]
// but
// val list2: MyList[B] = List[B](some, some1, some2)
// list.ToString() doesn't know how to print any subtype of A
trait MyList[-A] {

  def tail: MyList[A]
  def toString(): String
}

// Main is singleton object, static method only in object type
// 'main' method is static
object Main {
  def main(args: List[String]): Unit = {
    print("Dupa")
  }
}


// val -> readonly/immutable
// var -> writeable/mutable
val a: Int = 0
var e: Int = 0
//a = 2 does not work
//e = 2 does work

//
class Graph {
  private var matrix: Array[Array[Int]] = _;
  private var size: Int = 0;

  def this(size: Int) = {
    this()
    this.size = size
    this.matrix = Array.ofDim[Int](size, size)
  }

  def resizeMatrix(width: Int, height: Int) = ???

  def fillMatrix(from: Int, to: Int, value:Int) : Unit = {
    matrix(from)(to) = value
  }

  def getPath(from: Int, to: Int): Int = {
    matrix(from)(to)
  }

  override def toString: String = {
    var tempString: String = ""
    for( i<-0 until size; j<-0 until size)
    {
      if(j % size == 0){
        tempString += "\n";
      }
      tempString += s"${matrix(i)(j)} "
    }
    tempString
  }
}

//
case class Graph2(private val matrix: Array[Array[Int]], private val size: Int = 0) {

  def fillMatrix(from: Int, to: Int, value:Int) : Unit = {
    matrix(from)(to) = value
  }

  def getPath(from: Int, to: Int): Int = {
    matrix(from)(to)
  }

  override def toString: String = {
    var tempString: String = ""
    for( i<-0 until size; j<-0 until size)
    {
      if(j % size == 0){
        tempString += "\n";
      }
      tempString += s"${matrix(i)(j)} "
    }
    tempString
  }
}

//List concatenation
val listContat: Array[Int] = Array(1 , 2).++(Array(3, 4))
print(listContat)


//monomorphic function - only for one type
def findFirst(collection: Array[Int], value: Int): Int = {
  @tailrec
  def loop(n: Int): Int = {
    if (n >= collection.length) -1
    else if(collection(n) == value) n
    else loop(n+1)
  }
  loop(0)
}

//polymorphic function - generic
def findFirst[A](as: Array[A], p: A => Boolean): Int = {
  @tailrec
  def loop(n: Int): Int = {
    if (n >= as.length) -1
    else if (p(as(n))) n
    else loop(n+1)
  }
  loop(0)
}
// passing arguments to function
// evaluate a before passByValue will be execute
def passByValue(a: Int): Unit = ???

// evaluate a after passByValue will be execute inside body function
def passByName(a: => Int): Unit = {
  lazy val d: Int= a
  print(d)
}

findFirst(Array(7, 9, 13), (x: Int) => x == 9)
//functions as values, apply method on trait function
//Function0, Function1, Function2, Function3, ..., Function22

// infinite streams
val ones: Stream[Int] = Stream.cons(1, ones)

ones.exists( _ % 2 != 0)
ones.takeWhile(_ == 1)
ones.forall( _ != 1)


def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
  (a:A) => (b: B) => f(a, b)
}

def uncurry[A, B, C](f: B => C, g: A => B): A => C = {
  (a:A) => f(g(a))
}

sealed trait SampleList[+A]
case object Nil extends SampleList[Nothing]
case class Cons[+A] (head: A, tail: SampleList[A]) extends SampleList[A]

object List {
  def sum(ints: SampleList[Int]): Int = ints match {
    case Nil => 0
    case Cons(h, t) => h + sum(t)
  }

  def product(ds: SampleList[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(h, t) => h * product(t)
  }

  def apply[A](as: A*): SampleList[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}
//1 :: List(2) // will return List(1,2)
//List(1) ::: List(2, 3) // will return List(1,2,3)


