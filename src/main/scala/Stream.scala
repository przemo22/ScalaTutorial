package com.app.learning

sealed trait Stream[+A]
case object Empty extends Stream[Nothing]
case class StrCons[+A] (h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: => A, t1: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = t1
    StrCons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def headOption[A]: Option[A] = this() match {
        case Empty => None
        case StrCons(h, t) => Some(h())

      }

  def apply[A](as: A*): Stream[A] =
    if(as.isEmpty) empty else cons(as.head, apply(as.tail: _*))

}
