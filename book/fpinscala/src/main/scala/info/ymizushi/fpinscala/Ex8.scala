

// val intList = Gen.listOf(Gen.choose(0, 100))
// val prop = forAll(intList)(ns => ns.reverse.rreverse == ns) && forAll(intList)(ns => ns.headOption == ns.reverse.lastOption_
// val failingProp = forAll(intList)(ns => ns.reverse == ns)
// 
// 
// val prop = forAll(Gen.listOf(Gen.choose(0, 100)))(ns => ns.reverse.sum == ns.sum) 
// && forAll(Gen.listOf(Gen.const(100, 100, 100)))(ns => ns.length * ns.first == ns.sum) 
// && forAll()(ns => (1 + ns.last) * ns.length / 2 == ns.sum) 
// 
// val intList = Gen.listOf(Range(0, 100, 2))
// 
// 
// 
// val intList = Gen.listOf(Gen.choose(0, 100))
// val prop = forAll(intList)(ns => ns.max == ns.sorted.last) 
// && forAll(Gen.listOf(Gen.const(100) * 100)(ns => ns.max == ns.head)
// && forAll(Gen.listOf(Gen.const(100) * 100)(ns => ns.max == ns.last)
