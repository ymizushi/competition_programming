myLast :: [a] -> a
myLast [] = error "nil is not pemitted"
myLast [head] = head
myLast (_ : tail) = myLast tail


myButLast :: [a] -> a
myButLast [] = error "nil is not pemitted"
myButLast [last] = error "1 element is not pemitted"
myButLast [top, last] = last
myButLast (_ : tail) = myButLast tail



main = do
  print $ myLast [1, 2, 3]
  print $ myButLast [1, 2, 3, 4]
