import Data.List

numUniques :: (Eq a) => [a] -> Int
numUniques = length . nub


wordCount ::  String -> [(String, Int)]
wordCount str = (map (\l -> (head l, length l)) (group $ sort (words str)))

f >| g = g . f

main = do
  print $ numUniques [1, 5, 3, 2, 1, 6, 4, 3, 2, 1]
  print $ wordCount "piyo hoge piyo hoge"
  let hoge = (+2) >| (*4)
  print $ wordCount "piyo hoge piyo hoge"
  print $ hoge 2




