-- bmiTell :: Double -> String
-- bmiTell bmi | bmi <= 18.5 = "You are under wieght you emo, you"
--             | bmi <= 25.0 = "You are suporsed nomal"
--             | bmi <= 30.0 = "You are fat"
--             | otherwise = "You are a wahel congraturation"

max' :: (Ord a) => a -> a -> a

myCompare :: (Ord a) => a -> a -> Ordering
a `myCompare` b 
  | a == b = EQ
  | a <= b = LT
  | otherwise = GT

max' a b 
  | a <= b = b
  | otherwise = a

bmiTell :: Double -> Double -> String
bmiTell weight height
  | bmi <= 18.5 = "You are under "
  | bmi <= 25.0 = "you are suposedly normal"
  | bmi <= 30.0 = "You are fat"
  | otherwise = "You are a ahwle congraturation"
   where 
      bmi = weight / height ^ 2
      (skinny, normal, fat) = (18.5, 25.0, 30.0)

initials :: String -> String -> String
initials firstname lastname = [f] ++ ". " ++ [l] ++ "."
  where (f:_) = firstname
        (l:_) = lastname


calcBmis :: [(Double, Double)] -> [Double]
calcBmis xs = [bmi w h | (w, h) <- xs ]
  where bmi weight height = weight / height ^ 2

cylinder :: Double -> Double -> Double
cylinder r h =
  let 
    sideArea = 2 * pi * r * h 
    topArea = pi * r ^ 2 in 
    let piy = 2 in 
      sideArea + 2 * topArea



main = do
 -- print $ bmiTell 40.0
 print $ max' 30 20
 print $ 4 `myCompare` 4
 print $ bmiTell 10 20
 print $ initials "Yuta" "Mizushima"
 print $ calcBmis [(62.0, 1.64), (93.0, 1.76)]
 print $ cylinder 20.0 50.0
 
