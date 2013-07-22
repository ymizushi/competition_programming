n = 5
s = [1, 2, 4, 6, 8, 10, 11]
t = [3, 5, 7, 9, 10, 14, 13]

def exclude_list(sublist, all_list):
    subset = set(sublist)
    allset = set(all_list)
    if subset.issubset(allset):
        return list(allset.difference(subset))
    else:
        return None

def exclude_list_list(sublist, all_list):
    return filter(lambda x: x != sublist, all_list)

all_st = range(min(s + t),max(s+t))
# print all_st
# print "intersetction", exclude_list([1,2,3,4], [1,2,3,4,5,6])

t_s = map(lambda x: range(x[0], x[1]), zip(s, t))

# len_t_s = map(lambda x: len(x), t_s)
# min_len = min(len_t_s)
# 
# print t_s
# print len_t_s

def calc(sublist, alllist, count):
    for sub in sublist:
        if set(sub).issubset(set(alllist)):
            return calc(exclude_list_list(sub, sublist), exclude_list(sub, alllist), count+1)
        else:
            continue
    return count
print calc(t_s, all_st, 0)
