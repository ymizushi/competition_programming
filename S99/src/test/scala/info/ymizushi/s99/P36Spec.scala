package info.ymizushi.S99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P36Spec extends FunSpec with DiagrammedAssertions {
  describe("P36") {
    it("success") {
      import P36.AddInt
      assert(10.primeFactorMultiplicity == List((2,1), (5, 1)))
      assert(315.primeFactorMultiplicity == List((3,2), (5,1), (7,1)))
    }
  }
}
