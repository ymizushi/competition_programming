package info.ymizushi.S99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P38Spec extends FunSpec with DiagrammedAssertions {
  describe("P38") {
    it("success") {
      val start = System.currentTimeMillis
      assert(P38.phiByP34(10090) == 4032)
      val middle = System.currentTimeMillis
      println(middle - start)
      assert(P38.phiByP37(10090) == 4032)
      val end = System.currentTimeMillis
      assert((middle-start) > (end - middle) * 5000 )
      
    }
  }
}
