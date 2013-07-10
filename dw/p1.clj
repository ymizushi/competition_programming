; 整数a1, a2, ..., anが与えられます。その中からいくつか選び、その和を丁度kにすることができるか判定しなさい。
; 
; 制約 (iは任意の整数)
; 
; 1 ≦ n ≦ 20
; -10^8 ≦ ai ≦ 10^8
; -10^8 ≦ k ≦ 10^8

; n=20
; a = {1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8,13}
; k=444



;# n=20
;# a = [1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8,13]
;# k=444
;# 
;# a.sort();
;# print a
;# 
;# a_sorted = [-500, -23, 1, 1, 3, 3, 7, 8, 8, 10, 10, 13, 13, 23, 42, 45, 49, 49, 60, 599]
;# 
;# print sum(filter(lambda x: x> 0, a))
;# print sum(filter(lambda x: x<= 0, a))
;# 
;# 
;# 
;# 
;# 
;# 
;# positive_hoge = [1, 1, 3, 3, 7, 8, 8, 10, 10, 13, 13, 23, 42, 45, 49, 49, 60, 599]
;# 
;# a = [1,2,4,7]
;# k = 13
;# 
;# 
;# 
;# a = [1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8,13]
;# def nc2_pat(a):
;#     for e in a:
;#         pass
;# 
;
;def select_ele(list):
;    return (list.pop(0), list)
;
;def select_eleset(eleset):
;    hoge = eleset[1]
;    return_list = []
;    while hoge:
;        return_list.append((eleset[0],hoge.pop()))
;    return (hoge, return_list)
;
;# print select_ele([1,2,3,4,5])
;# 
;# print select_eleset((5, [1, 2, 3, 4]))
;
;print select_eleset(select_ele([1,2, 3,4,5]))
;
;
;
;
;
