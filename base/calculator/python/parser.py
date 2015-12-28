#!/usr/bin/env python
# -*- coding: utf-8 -*-

import re
import unittest


def Num(object):
    def __init__(self):
        pass

def Op(object):
    pass


def Exp(object):
    pass


def Priority(object):
    pass


class State(object):
    def __init__(self):
        self.output = ''

    def is_num(self, char):
        return char in [str(i) for i in range(10)]

    def input(self, char):
        if char == ' ':
            return None
        elif self.is_num(self.output) and self.is_num(char):
            self.output += char
            return None
        else:
            rvalue = self.output
            self.output = char
            return rvalue

def tokenize(input_str):
    tokens = []
    state = State()
    for char in input_str+'\n':
        result = state.input(char)
        if result:
            tokens += [result]
    return tokens


print(tokenize("( 123  +  345)"))


class TestMerge(unittest.TestCase):
    def parse(self, s):
        pass

    def test_solve(self):
        pass

if __name__ == '__main__':
    unittest.main()

