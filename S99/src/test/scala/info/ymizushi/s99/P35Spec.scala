package info.ymizushi.S99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P35Spec extends FunSpec with DiagrammedAssertions {
  describe("P35") {
    it("success") {
      import P35.AddIntTo
      assert(10.primeFactors == List(2,5))
    }
  }
}
