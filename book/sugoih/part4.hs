maximum' :: (Ord a) => [a] -> a

maximum' [a] = a
maximum' (head : tail) = let maxTail = maximum(tail) in 
  if head < maxTail then
    maxTail
  else 
    head 

replicate' :: Int -> a -> [a]
replicate' n x
  | n <= 0 = []
  | otherwise = x : replicate' (n-1) x

take' :: Int -> [a] -> [a]
take' n _
  | n <= 0 = []
take' _ [] = []
take' n (x:xs) = x : take' (n-1) xs

repeat' :: a -> [a]
repeat' x = x : repeat' x

zip' :: [a] -> [b] -> [(a, b)]
zip' _ [] = []
zip' [] _ = []
zip' (x:xs) (y:ys) = (x,y) : zip' xs ys


elem' :: (Eq a) => a -> [a] -> Bool
elem' a [] = False
elem' a (x:xs)
  | a == x = True
  | otherwise = a `elem'` xs

smallerList :: (Ord a) => a -> [a] -> [a]
smallerList y (x: xs) = 
  if y > x then
    x : (smallerList y xs)
  else
    smallerList y xs
smallerList _ [] = []

biggerList :: (Ord a) => a -> [a] -> [a]
biggerList a (x: xs) = 
  if a <= x then
    x : biggerList a xs
  else
    biggerList a xs
biggerList _ [] = []
    
    
quick :: (Ord a) => [a] -> [a]
quick (x:xs) = 
  quick (smallerList x xs) ++ [x] ++ quick (biggerList x xs)
quick [] = []

quicksort :: (Ord a) => [a] -> [a]
quicksort [] = []
quicksort (x:xs) =
    quicksort smallerOrEqual ++ [x] ++ quicksort larger where
        smallerOrEqual = [a | a <- xs, a <= x]
        larger = [a | a <- xs, a > x] 
  
multThree :: Int -> Int -> Int -> Int
multThree x y z = x * y * z

applyTwice :: (a -> a) -> a -> a
applyTwice f x = f (f x)

main = do
 -- print $ bmiTell 40.0
 print $ maximum' [10, 20, 15]
 print $ take 5 (repeat' 10)
 print $ zip [1, 2, 3] [4, 5, 6]
 print $ elem 10 [10, 0, 20, 30]
 print $ quick [10, 0, 20, 30, 35, 20, 11] 
 print (multThree 3 5 9)
