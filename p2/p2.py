def fib_r(n):
    if n is 0:
        return 1
    if n is 1:
        return 2
    return fib(n-2)+fib(n-1)

def fib(n):
    if n is 0:
        return 1
    if n is 1:
        return 2
    a0 = 1
    a1 = 2
    now = a0+a1
    for a in range(2,n):
        a0 = a1
        a1 = now
        now = a0+a1
    return now

def fib_list():
    fib_list = []
    n = 0
    while True:
        fibn = fib(n)
        if fibn > 4000000:
            return fib_list
        fib_list.append(fib(n))
        n += 1
        # fib_list.append(fib_r(n))

sum_num = 0
for num in fib_list():
    if num %2 == 0:
        sum_num += num
print "sum", sum_num
