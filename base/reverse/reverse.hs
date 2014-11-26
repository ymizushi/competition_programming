fib n =
  if n <= 2 then
    1
  else
    fib(n-2) + fib (n-1)

reve input::String output::String = 
  if input == "" then
    output
  else
    reve (tail(input) head(input)++output)

main = print (reverse 9)
