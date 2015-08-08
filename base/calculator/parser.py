#!/usr/bin/env python
# -*- coding: utf-8 -*-

import re
import unittest


class TestMerge(unittest.TestCase):
    def parse(self, s):
        input = ''
        for c in s:
            if c != ' ':
                input += c
            # parse_regex  = '^[0]$|^[1-9][0-9]*|^[+-/*()]$'
            parse_regex  = '^[1-9][0-9]*'
            result = re.match(parse_regex, input)
            print(input)
            if result:
                yield result

    def test_solve(self):
        gen = self.parse("1232")
        self.assertEqual(gen.next().group(0), '1')

if __name__ == '__main__':
    unittest.main()

