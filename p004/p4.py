#!/usr/bin/env python
# -*- coding: utf-8 -*-
import unittest

def max_palid():
    for n in range(989, 100, -1):
        for x in range(999, 100, -1):
            target = int(str(n) + str(n)[::-1])
            y = target / x
            if (target % x == 0 and len(str(y)) == 3):
                return target

class TestMerge(unittest.TestCase):
    def test_solve(self):
        expected = 906609
        self.assertEqual(max_palid(), expected)

if __name__ == '__main__':
    unittest.main()
