package info.ymizushi.S99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P39Spec extends FunSpec with DiagrammedAssertions {
  describe("P39") {
    it("primes") {
      assert(P39.listPrimesInRange(1 to 10) == List(2, 3, 5, 7))
      assert(P39.listPrimesInRange(100 to 110) == List(101, 103, 107, 109))
    }
  }
}


