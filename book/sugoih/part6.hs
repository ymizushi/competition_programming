import Data.Char
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

encode :: Int -> String -> String
encode offset msg = map (\c -> chr $ ord c + offset) msg

sumKeta :: Int -> Int
sumKeta = sum . map digitToInt . show

firstSum40 :: Int  -> Int
firstSum40 n 
  | sumK == 40 =  n
  | otherwise = firstSum40 (n+1)  
  where sumK = sumKeta n

-- module Geometry.Sphere
-- ( volume
-- , area
-- ) where
--

data Person = Person { firstName :: String
                     , lastName :: String
                     , age :: Int
                     , height :: Float
                     , phoneNumber :: String
                     , flavor :: String } deriving (Show)

volume :: Float -> Float
volume radius = (4.0 / 3.0) * pi * (radius ^ 2)

main = do
  --- print $ numUniques [1, 5, 3, 2, 1, 6, 4, 3, 2, 1]
  --- print $ wordCount "piyo hoge piyo hoge"
  --- let hoge = (+2) >| (*4)
  --- print $ wordCount "piyo hoge piyo hoge"
  --- print $ hoge 2
  print $ tails' ""
  print $ tails' "abcde"
  print $ sumKeta 49998
  print $ firstSum40 49998
