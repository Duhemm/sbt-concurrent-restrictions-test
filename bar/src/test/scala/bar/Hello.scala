package bar

import org.scalatest._
import flatspec._
import matchers._

class Hello extends AnyFlatSpec with should.Matchers {

  "hello" should "hello" in {
    Thread.sleep(1000)
  }
}
