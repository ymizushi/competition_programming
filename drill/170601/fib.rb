def fib(n)
    if n == 1 || n == 2
        1
    else
        fib(n-2) + fib(n-1)
    end
end
# time 36s
p fib(10)

def fib2 n
    def fibl(ln, a, b, n)
        if n == 1 || n ==2
            return 1
        end
        if ln == n 
            return a+b
        end
        fibl(ln+1, b, a+b, n)
    end
    fibl(1, 0, 1, n)
end
# time 3m
p fib2(8)
