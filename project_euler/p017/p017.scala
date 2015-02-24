val hashMap = Map(
   1   -> "one"          ,
   2   -> "two"          ,
   3   -> "three"        ,
   4   -> "four"         ,
   5   -> "five"         ,
   6   -> "six"          ,
   7   -> "seven"        ,
   8   -> "eight"        ,
   9   -> "nine"         ,
  10   -> "ten"          ,
  11   -> "eleven"       ,
  12   -> "twelve"       ,
  13   -> "thirteen"     ,
  14   -> "fourteen"     ,
  15   -> "fifteen"      ,
  16   -> "sixteen"      ,
  17   -> "seventeeen"   ,
  18   -> "eighteen"     ,
  19   -> "nineteen"     ,
  20   -> "tweynty"      ,
  30   -> "thirty"       ,
  40   -> "fourty"       ,
  50   -> "fifty"        ,
  60   -> "sixty"        ,
  70   -> "seventy"      ,
  80   -> "eighty"       ,
  90   -> "nighty"       ,
  100  -> "one hundred"  ,
  1000 -> "one thousand"
)

def count(str: String): Int {
  str.filter(c => c != ' ').

}

println(hashMap)
println(hashMap.get(2))

