package introduction.homework

import `00`.homework.Recursion.{factorial, pascal}


class RecursionSuite extends munit.FunSuite:

  test("pascal: col=0,row=2") {
    assertEquals(pascal(0, 2), 1)
  }

  test("pascal: col=1,row=2") {
    assertEquals(pascal(1, 2), 2)
  }

  test("pascal: col=1,row=3") {
    assertEquals(pascal(1, 3), 3)
  }


  test("factorial: n = 0") {
    assertEquals(factorial(0), 0)
  }

  test("factorial: n = 1") {
    assertEquals(factorial(1), 0)
  }

  test("factorial: n = 9") {
    assertEquals(factorial(9), 	362880)
  }
