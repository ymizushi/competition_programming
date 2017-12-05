package info.ymizushi.S99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P37Spec extends FunSpec with DiagrammedAssertions {
  describe("P37") {
    it("success") {
      assert(P37.phi(10) == 4)
    }
  }
}
