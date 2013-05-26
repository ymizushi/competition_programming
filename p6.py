def sum_of_squares(n):
    return  sum(range(1,n+1))*sum(range(1,n+1))
def squares_of_sum(n):
    return sum([i*i for i in range(1,n+1)])

def ssd(n):
    return sum_of_squares(n)-squares_of_sum(n)
print ssd(100)
