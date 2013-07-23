#!/usr/bin/env python
# -*- coding: utf-8 -*-

class GreedMethod():
    # ファイルからテストデータ読み込み
    def parse(self, filename):
        data = dict()
        with open(filename) as f:
            for line in f:
                data_set = line.strip('\n').split(' ')
                data[data_set[0]] = data_set[1].split(',')
        return data

    def __init__(self,filename):
        test_data =  self.parse(filename)
        s = map(lambda x: int(x), test_data.get('s'))
        t = map(lambda x: int(x), test_data.get('t'))
        self.all_st = range(min(s + t),max(s+t))
        self.t_s = sorted(map(lambda x: range(x[0], x[1]), zip(s, t)), key=lambda x:len(x))

    def exclude_list(self,sublist, all_list):
        subset = set(sublist)
        allset = set(all_list)
        if subset.issubset(allset):
            return list(allset.difference(subset))
        else:
            return None

    def exclude_list_list(self,sublist, all_list):
        return filter(lambda x: x != sublist, all_list)


    def calc(self,sublist, alllist, count):
        for sub in sublist:
            if set(sub).issubset(set(alllist)):
                return self.calc(self.exclude_list_list(sub, sublist), self.exclude_list(sub, alllist), count+1)
            else:
                continue
        return count
