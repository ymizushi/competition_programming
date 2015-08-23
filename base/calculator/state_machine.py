#!/usr/bin/env python
# -*- coding: utf-8 -*-


class NumState(object):
    START = 0
    A = 1
    END = 2

    def __init__(self):
        self.state = self.START
        self.output = ''

    def input(self, char):
        if self.state  == self.START:
            if char in [str(x) for x in range(1,10)]:
                self.state = self.A
                self.output += char
            else:
                pass
        elif self.state  == self.A:
            if char in [str(x) for x in range(0,10)]:
                self.output += char
            else:
                self.output += char
                self.state = self.END
        if self.state == self.END:
            self.state = self.START
            print self.output
            self.output = ''
            return 'accepted'

state = NumState()
for c in "+ 123 123 0142 33 42 513 ":
    result = state.input(c)

