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

def revrec(input, output):
    if input == "":
        return output
    else:
        c = input[0]
        rest = input[1:]
        return revrec(rest, c+output)

print revrec("hoge", "")
print revrec("hoge", "")

class TestMerge(unittest.TestCase):
    def test_solve(self):
        input    = "foobar"
        expected = "raboof" 
        self.assertEqual(reverse(input), expected)
if __name__ == '__main__':
    unittest.main()
