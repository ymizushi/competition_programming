import math
def is_prime(n):
    print "n",n
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
counter = max_range/divide_num
while counter > 0:
    if max_range % counter == 0 and is_prime(counter):
        print "result:" , counter
        break
    else:
        counter -= 1
        # divide_num += 1
        # counter = max_range/divide_num
