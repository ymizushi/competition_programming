def list_factor(n):
    factor_list = []
    for i in range(1,n+1):
        if n % i == 0 and not i in factor_list:
            factor_list += [i]
    return factor_list

def triangle_number

def is_over_count(count,n):
    if len(list_factor(n)) > count:
        print "over count:", count, " :n",n
