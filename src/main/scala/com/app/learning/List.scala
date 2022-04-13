package com.app.learning

import scala.annotation.tailrec

trait List[+A] {
  val head: A
  val tail: List[A]
}
case object Nil extends List[Nothing] {
  override val head: Nothing = head
  override val tail: List[Nothing] = List()

}
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

  def tail[A](): List[A] = this.tail() match {
    case Nil => Nil
    case Cons(_, t) => t
  }

  def setHead[A](element: A): Cons[A] = this.tail() match {
    case Nil => Cons(element, List(element))
    case Cons(currentHead, tail) => Cons(element, Cons(currentHead, tail))
  }

  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Nil => Nil
    case Cons(h, t) => drop(l.tail, n-1)
  }

  def dropWhile[A](as: List[A], f: A => Boolean): List[A] = as match {
    case Cons(h, t) if f(h) => dropWhile(t,f)
    case _ => as
  }

//  def dropWhile[A](as: List[A])(f: A => Boolean): List[A] = as match {
//    case Cons(h, t) if f(h) => dropWhile(t)(f)
//    case _ => as
//  }


  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}

