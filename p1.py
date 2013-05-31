num_list = filter( lambda x:x % 3 == 0 or x % 5 == 0, range(1,1000))
# for x in range(1,1000):
#     if x % 3 == 0 or x % 5 == 0:
#         num_list.append(x)

print "result:", sum(num_list)
