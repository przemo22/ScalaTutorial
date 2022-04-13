package `00`.homework

object HigherOrderFunction {

  // todo: implement method
  def curry[C, A, B](f: ((C, A)) => B): C => A => B =
    ???

  // todo: implement method
  def uncurry[C, A, B](f: C => A => B): ((C, A)) => B =
    ???

  // todo: implement method
  def func1[C, A, B](fst: C => A, snd: C => B): C => (A, B) =
    ???

  // todo: implement method
  def func2[C, A, B](h: C => (A, B)): (C => A, C => B) =
    ???

  // todo: implement method
  def func3[A, A1, B, B1](f: A => A1, g: B => B1): ((A, B)) => (A1, B1) =
    ???

}
