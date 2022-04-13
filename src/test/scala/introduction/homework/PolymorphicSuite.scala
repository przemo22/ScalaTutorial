package introduction.homework

import `00`.homework.Polymorphic.{filterMono, filterPoly}


class PolymorphicSuite extends munit.FunSuite:
  test("filterMono predicate: positive numbers") {
    val positiveNums = filterMono(x => x > -1, List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    assertEquals(positiveNums, List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  }

  test("filterMono predicate: only zero") {
    val positiveNums = filterMono(x => x == 0, List( 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ) )
    assertEquals(positiveNums, List(0))
  }

  test("filterMono predicate: anything") {
    val positiveNums = filterMono(x => x == 0, List() )
    assertEquals(positiveNums, List())
  }

  test("filterPoly predicate: positive numbers") {
    val positiveNums = filterPoly(x => x > -1, List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    assertEquals(positiveNums, List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  }

  test("filterPoly predicate: only zero") {
    val positiveNums = filterPoly(x => x == 0, List( 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ) )
    assertEquals(positiveNums, List(0))
  }

  test("filterPoly predicate: anything") {
    val positiveNums = filterPoly(x => x == 0, List() )
    assertEquals(positiveNums, List())
  }

  test("filterPoly predicate: start strings with M") {
    val positiveNums = filterPoly( _ startsWith "M" , List("Pat, Michael, Scott", "Merry"))
    assertEquals(positiveNums, List("Michael", "Merry"))
  }


