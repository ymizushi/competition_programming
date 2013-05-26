def is_prime(n):
    if n is 1:
        return False
    for i in range(2,n/2):
        if n % i is 0:
            return False
    return True

prime_list = []
last_prime = 2
for i in range(1,600851475143):
    if is_prime(i):
        last_prime = i
        # prime_list.append(i)
# print "prime_list",prime_list
# print "prime_list[-1]",prime_list[-1]
print last_prime
