#!/usr/bin/env python
# -*- coding: utf-8 -*-

# ファイルからテストデータ読み込み
def parse(filename):
    data = dict()
    with open(filename) as f:
        for line in f:
            data_set = line.strip('\n').split(' ')
            data[data_set[0]] = data_set[1]
    return data
test_data =  parse('test_data.txt')
s = test_data.get('s')
t = test_data.get('t')

# メモ化のためのハッシュマップを用意
memo_map = dict()
def gen_key(x, y):
    return str(x)+"_"+str(y)
def get_memo(x, y):
    key = gen_key(x, y)
    if memo_map.get(key):
        return memo_map[key]
    return None
def set_memo(x, y, count):
    key = gen_key(x, y)
    memo_map[key] = count

# (x, y-1), (x-1, y), がわかれば(x ,y)が計算出来る
def calc(x, y):
    if x < 0 or y < 0 or len(s)-1 < x or len(t)-1 < y: # index外は 0を返す
        return 0

    # s[index] == t[index]なら カウントを増やす
    up_count = 0
    if s[x] == t[y]:
        up_count +=1

    # (x, y-1)についてメモ化されていれば取得、無ければ計算してメモ化
    calcx = get_memo(x, y-1)
    if not calcx:
        calcx = calc(x, y-1)
        set_memo(x,y-1,calcx)

    # (x-1, y)についてメモ化されていれば取得、無ければ計算してメモ化
    calcy = get_memo(x-1, y)
    if not calcy:
        calcy = calc(x-1, y)
        set_memo(x-1, y, calcy)

    return max(calcx, calcy) + up_count

# sの長さ * tの長さだけループ
def __main__():
    max_count = 0
    for y in range(len(t)):
        for x in range(len(s)):
            calc_count = calc(x, y)
            if calc_count > max_count:
                max_count = calc_count
    print max_count

if __name__ == '__main__':
    __main__()
