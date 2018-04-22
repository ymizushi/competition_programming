import Data.List

numUniques :: (Eq a) => [a] -> Int
numUniques = length . nub


wordCount ::  String -> [(String, Int)]
wordCount str = (map (\l -> (head l, length l)) (group $ sort (words str)))

tails' :: [a] -> [[a]]
tails' [] = [[]]
tails' (head : tail) = (head : tail) : (tails' tail)

isIn :: (Eq a) => [a] -> [a] -> Bool
needle `isIn` haystack = any (needle `isPrefixOf`) (tails haystack)

f >| g = g . f

import Data.Char
encode :: Int -> String -> String
encode offset msg = map (\c -> chr $ ord c + offset) msg

main = do
  --- print $ numUniques [1, 5, 3, 2, 1, 6, 4, 3, 2, 1]
  --- print $ wordCount "piyo hoge piyo hoge"
  --- let hoge = (+2) >| (*4)
  --- print $ wordCount "piyo hoge piyo hoge"
  --- print $ hoge 2
  print $ tails' ""
  print $ tails' "abcde"
