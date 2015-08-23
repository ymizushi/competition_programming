#!/usr/bin/env python
# -*- coding: utf-8 -*-

import unittest

def fizz_buzz(n):
    output = []
    for i in range(1, n+1):
        if i % 15 == 0:
            output += ['Fizz Buzz']
        elif i % 3 == 0:
            output += ['Fizz']
        elif i % 5 == 0:
            output += ['Buzz']
        else:
            output += [i]
    return output

class TestMerge(unittest.TestCase):
    def test_solve(self):
        self.assertEqual(fizz_buzz(15), [1, 2, 'Fizz', 4, 'Buzz', 'Fizz', 7 , 8 ,'Fizz' , 'Buzz', 11, 'Fizz' ,13 , 14, 'Fizz Buzz'])
if __name__ == '__main__':
    unittest.main()
