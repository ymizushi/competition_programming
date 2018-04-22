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

main = do
  print $ myLast [1, 2, 3]
  print $ myButLast [1, 2, 3, 4]
  print $ elementAt'[1, 2, 3] 2
  print $ elementAt'"haskell" 5
  print $ myLength [123, 456, 789]
  print $ myLength "Hello, world!"
