#!/usr/bin/env python
# -*- coding: utf-8 -*-

# ファイルからテストデータ読み込み

class P4():
    def parse(self, filename):
        data = dict()
        with open(filename) as f:
            for line in f:
                data_set = line.strip('\n').split(' ')
                data[data_set[0]] = data_set[1]
        return data

    # メモ化のためのハッシュマップを用意
    def gen_key(self, x, y):
        return str(x)+"_"+str(y)

    def get_memo(self, x, y):
        key = self.gen_key(x, y)
        if self.memo_map.get(key):
            return self.memo_map[key]
        return None

    def set_memo(self, x, y, count):
        key = self.gen_key(x, y)
        self.memo_map[key] = count

    def __init__(self, filename):
        test_data = self.parse(filename)
        self.s = test_data.get('s')
        self.t = test_data.get('t')
        self.memo_map = dict()

    # (x, y-1), (x-1, y), がわかれば(x ,y)が計算出来る
    def calc(self, x, y):
        if x < 0 or y < 0 or len(self.s)-1 < x or len(self.t)-1 < y: # index外は 0を返す
            return 0

        # s[index] == t[index]なら カウントを増やす
        up_count = 1 if self.s[x] == self.t[y] else 0

        # (x, y-1)についてメモ化されていれば取得、無ければ計算してメモ化
        calcx = self.get_memo(x, y-1)
        if not calcx:
            calcx = self.calc(x, y-1)
            self.set_memo(x,y-1,calcx)

        # (x-1, y)についてメモ化されていれば取得、無ければ計算してメモ化
        calcy = self.get_memo(x-1, y)
        if not calcy:
            calcy = self.calc(x-1, y)
            self.set_memo(x-1, y, calcy)

        return max(calcx, calcy) + up_count

    # sの長さ * tの長さだけループ
    def calc_all(self):
        max_count = 0
        for y in range(len(self.t)):
            for x in range(len(self.s)):
                calc_count = self.calc(x, y)
                if calc_count > max_count:
                    max_count = calc_count
        return max_count
