import math
def is_prime(n):
    if n is 1:
        return False
    elif n is 2:
        return True
    counter = 2
    while counter <= int(math.sqrt(n)):
        if n % counter is 0:
            return False
        counter += 1
    return True

prime_list = []
max_range = 600851475143
# max_range = 111
divide_num = 2
counter = 2
while counter <= max_range:
    if max_range % counter == 0 and is_prime(counter):
        max_range /= counter
        print "counter",counter
        print "max_range",max_range
        counter = 2
        continue
    counter += 1
