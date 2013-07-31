N = 4
L = 25
P = 10
A = [10, 14, 20, 21, 25]
B = [10 , 5,  2  ,4, 0]
C = [False , False,  False  ,False, False]

stands = zip(A,B)
stands_length = len(stands)

# def can_go_next(now_fuel, now_index, next_index):
#     now_stand =  stands[now_index]
#     next_stand = stands[next_index]
#     estimate_next_fuel = now_fuel - (next_stand[0] - now_stand[0])
#     if estimate_next_fuel >= 0:
#         return True
#     return False

def go_next(now_fuel,now_index,next_index):
    now_stand = stands[now_index]
    next_stand = stands[next_index]
    next_fuel = now_fuel - (next_stand[0] - now_stand[0]) + next_stand[1]
    if next_fuel >= 0:
        C[next_index] = True
        return next_fuel
    else:
        C[next_index] = False
        return None

def search(now_fuel, now_index, next_index):
    if go_next(now_fuel, now_index, next_index):
    return search(next_fuel, next_index, next_index+1)
    else:
        if now_index == stands_length -2:
            return False
        else:
            return search(now_fuel, next_index, next_index+1)

# print search(10, 0, 1)
