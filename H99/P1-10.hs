-- P1
myLast :: [a] -> a
myLast [] = error "nil is not pemitted"
myLast [head] = head
myLast (_ : tail) = myLast tail


-- P2
myButLast :: [a] -> a
myButLast [] = error "nil is not pemitted"
myButLast [last] = error "1 element is not pemitted"
myButLast [top, last] = last
myButLast (_ : tail) = myButLast tail

-- P3
elementAt' :: [a] -> Int -> a
elementAt' [] n = error "out of index"
elementAt' (head : tail) 1 = head
elementAt' (head : tail) n 
  | n < 1 = error "ouf of index"
  | otherwise =   elementAt' tail (n-1)

-- P4
myLength :: [a] -> Int
myLength [] = 0
myLength (head : tail) = 1 + myLength tail

-- P5
myReverse :: [a] -> [a]
myReverse = foldl (flip (:)) []

-- P6
isPalindrome :: (Eq a) => [a] -> Bool
isPalindrome l =  l == reverse l

-- P8
compress :: (Eq a) => [a] -> [a]
compress l = innerCompress l []
  where 
    innerCompress :: (Eq a) => [a] -> [a] -> [a]
    innerCompress [] acc = acc
    innerCompress (h:tail) acc
      | acc == [] = innerCompress tail [h]
      | h == (head acc) = innerCompress tail acc
      | otherwise = innerCompress tail (acc ++ [h])

main = do
  print $ myLast [1, 2, 3]
  print $ myButLast [1, 2, 3, 4]
  print $ elementAt'[1, 2, 3] 2
  print $ elementAt'"haskell" 5
  print $ myLength [123, 456, 789]
  print $ myLength "Hello, world!"
  print $ myReverse "A man, a plan, a canal, panama!"
  print $ myReverse [1, 2, 3, 4]
  print $ isPalindrome [1, 2, 3]
  print $ isPalindrome "madamimadam"
  print $ isPalindrome [1,2,4,8,16,8,4,2,1]
  -- 次回 isPalindromeを別のやり方で解いてみる
  print $ compress "aaaabccaadeeee"

