#!/usr/bin/env python
# -*- coding: utf-8 -*-
import unittest

def reverse(str):
    stack = []
    for c in str:
        stack += [c]
    reversed_str = ""
    while True:
        if stack:
            reversed_str += stack.pop()
            continue
        return reversed_str

class TestMerge(unittest.TestCase):
    def test_solve(self):
        input    = "foobar"
        expected = "raboof" 
        self.assertEqual(reverse(input), expected)
if __name__ == '__main__':
    unittest.main()
