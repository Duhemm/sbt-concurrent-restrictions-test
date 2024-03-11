package foo

import org.scalatest._
import flatspec._
import matchers._

class World extends AnyFlatSpec with should.Matchers {

  "world" should "world" in {
    Thread.sleep(3000)
  }
}

