import scala.annotation.tailrec

1 + 1

val x = 42
var d = 42

//x = 2 // immutable
//d = 3 // mutable

x+x

val listContat = Array(1 , 2).++(Array(3, 4))


def factorial(n: Int): Int = {
  @tailrec
  def go(n: Int, acc: Int): Int =
    if(n <= 0) acc
    else go(n-1, n*acc)

  go(n,1)
}

val asd = factorial(3)

//higher order function monomorphic
def findFirst(collection: Array[Int], value: Int): Int = {
  @tailrec
  def loop(n: Int): Int = {
    if (n >= collection.length) -1
    else if(collection(n) == value) n
    else loop(n+1)
  }
  loop(0)
}

//higher-order polymorphic function
def findFirst[A](as: Array[A], p: A => Boolean): Int = {
  @tailrec
  def loop(n: Int): Int = {
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n+1)
  }
  loop(0)
}


//anonymous function
val concat = findFirst(listContat, (x: Int) => x==3)


//functions as values, apply method on trait function
//Function0, Function1, Function2, Function3, ..., Function22

// currying
def partial1[A,B,C](a :A, f: (A, B) => C): B => C = ???

def partial[A,B,C](a: A, f: (A, B) => C): B => C = {
  (b: B) => f(a, b)
}

def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
  (a:A) => (b: B) => f(a, b)
}

def uncurry[A, B, C](f: B => C, g: A => B): A => C = {
  (a:A) => f(g(a))
}


//Practice with uncurry
def compose[A,B,C](f: B => C, g: A=> B): A => C = {
  (a:A) => f(g(a))
}

val das = compose((b: Boolean) => {
  if(b) "Good"
  else "Not good"
}, (x: Int) => x >= 0);

das(0)

//Object, companion pattern matching
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A] (head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(h, t) => h + sum(t)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(h, t) => h * product(t)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}


val re = List(1,2,3,4,5) match {
  case Cons(x, Cons(2, Cons(4, _))) => x
  case Nil => 42
  case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
  case Cons(h, t) => h + List.sum(t)
  case _ => 101
}





