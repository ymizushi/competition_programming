#!/usr/bin/env python
# -*- coding: utf-8 -*-
import unittest

def merge(a, b):
    merge = []
    while(not (a == [] and b == [])):
        if (a == [] and b != []):
            pop_item = b.pop(0)
            merge += [pop_item]
        elif (a != [] and b == []):
            pop_item = a.pop(0)
            merge += [pop_item]
        elif (a[0] < b[0]):
            pop_item = a.pop(0)
            merge += [pop_item]
        else:
            pop_item = b.pop(0)
            merge += [pop_item]
    return merge

def split(l):
    middle = len(l)/2
    a = l[0:middle]
    b = l[middle:]
    return a, b

def sort_l(a):
    if len(a) > 2:
        x, y = split(a)
        sorted_x = sort_l(x)
        sorted_y = sort_l(y)
        return merge(sorted_x,sorted_y)
    if 1 <= len(a) <= 2:
        if len(a) == 1:
            return a
        else:
            if (a[0] < a[1]):
                return [a[0], a[1]]
            else:
                return [a[1], a[0]]
    else:
        raise Exception()

class TestMerge(unittest.TestCase):
    def test_solve(self):
        input    = [3, 4, 40, 2000, 50, 20, 111, 4, 5, 67,  80,  20,  5, 4, 2, 29, 10, 6]
        expected = [2, 3, 4, 4, 4, 5, 5, 6, 10, 20, 20, 29, 40, 50, 67, 80, 111, 2000] 
        self.assertEqual(sort_l(input), expected)

if __name__ == '__main__':
    unittest.main()
