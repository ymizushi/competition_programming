double x y = x * 2 + y * 2


equal x y = if x ==  y then True else  False
boomBangs xs = [ if x < 10 then "Boom!" else "BANG!" | x <- xs, odd x]

addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z

class Testable a where
    hoge :: a -> String
 
instance Testable Int where
    hoge n =
       if n == 0 then "0"
       else "1"


-- 直角三角形を見つける
is_triangle a b c = 
  if a <= 10 && b <= 10 && c <= 10 && a+b+c == 24 then
    True
  else
    False

hello :: Int -> String
hello x =
    hoge x


main = do
  -- let lostNumbers = [4, 8, 15, 16, 23, 42]
  -- print $ lostNumbers
  -- print $ lostNumbers ++ [1, 2, 3, 4]
  -- print $ [3, 2, 1] > [2, 1, 0]
  -- print $ length [3, 2, 1]
  -- print $ reverse [3, 2, 1]
  -- print $ null [3, 2, 1]
  -- print $ take 3 [3, 2, 1]
  -- print $ "Steve Buscemi" !! 6
  -- print $ equal 10 11
  -- print $ double 10 20
  -- print $ sum [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
  -- print $ product [6, 2, 1, 2]
  -- print $ [1..20]
  -- print $ [-3, 2..20]
  -- print $ take 24 [13, 26..]
  -- print $ take 21 (cycle [1,2 ,3 ,4])
  print $ take 10 (repeat 5)
  print $ replicate 3 10
  print $ [x*2 | x <- [1..10]]
  print $ [x*2 | x <- [1..10], x*2 >= 12]
  print $ [x | x <- [50..100], x `mod` 7 == 3]
  print $ boomBangs [1, 2, 3, 4]
  print $ [x+y | x <- [1, 2, 3], y <- [10, 100, 1000]]
  print $ is_triangle 6 9 10
  let tripes = [ (a, b, c) | c <- [1 .. 10], a <- [1 .. 10], b <- [1..10]]
  let rightTriangles = [ (a, b, c) | c <- [1 .. 10], a <- [1 .. c], b <- [1..a], a^2 + b^2 == c^2]
  print $ rightTriangles
  print $ hello 10
  
  
