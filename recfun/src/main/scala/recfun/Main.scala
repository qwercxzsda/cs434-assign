package recfun
import common._

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def isValid(c: Int, r: Int): Boolean = {
      0 <= c && c <= r
    }

    if (!isValid(c, r)) 0
    else if (r == 0) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def balance_aux(chars: List[Char], acc: Int): Boolean = {
      if (acc < 0) false
      else chars match {
        case '(' :: tail => balance_aux(tail, acc + 1)
        case ')' :: tail => balance_aux(tail, acc - 1)
        case _ :: tail => balance_aux(tail, acc)
        case _ => true
      }
    }

    balance_aux(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    coins match {
      case e :: tail =>
        // not a valid way to give change
        if (money < 0) 0
        // valid way to give change
        else if (money == 0) 1
        // to give the change, we can use the coin or skip the coin.
        else countChange(money - e, coins) + countChange(money, tail)
      case _ => 0
    }
  }
}
