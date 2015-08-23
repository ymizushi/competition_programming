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
    NUM = 'NUM'

    def __init__(self):
        self.state = None
        self.output = ''
    def input(self, char):
        if char in [str(i) for i in range(10)]:
            self.state = self.NUM
            self.output += char
            return None
        else:
            if self.output == '':
                return char
            else:
                return_value = self.output
                self.output = ''
                return return_value


def tokenize(input_str):
    tokens = []
    state = State()
    for char in input_str:
        result = state.input(char)
        if result:
            tokens += [result]
    return tokens


print (tokenize("( 123  +  345)"))


class TestMerge(unittest.TestCase):
    def parse(self, s):
        pass

    def test_solve(self):
        pass

if __name__ == '__main__':
    unittest.main()

