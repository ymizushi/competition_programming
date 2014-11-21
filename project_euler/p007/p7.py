from math import sqrt
def is_prime(n):
    if n is 1:
        return False
    for i in range(2, int(sqrt(n))+1):
        if n % i is 0:
            return False
    return True

def nth_prime(th):
    index = 0
    n = 2
    while True:
        if(is_prime(n)):
            index += 1
            if(index == th):
                return n
        n += 1
print nth_prime(10001)
