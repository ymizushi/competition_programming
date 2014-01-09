#!/usr/bin/env python
# -*- coding: utf-8 -*-

nth_tri_num_hash = {}
count_factor_hash = {}
have_n_divisors_hash = {}

def nth_tri_num(n):
    if (nth_tri_num_hash.get(str(n))):
        return nth_tri_num_hash.get(str(n))
    sum = 0
    i = 1
    while(True):
        if (i > n):
            nth_tri_num_hash[str(n)] = sum
            return sum
        else:
            sum += i
            i += 1

def count_factor(n):
    if (count_factor_hash.get(str(n))):
        return count_factor_hash.get(str(n))
    i = 1
    count = 0 
    while (True):
        if (i > n):
            count_factor_hash[str(n)] = count
            return count
        else:
            if (n % i == 0):
                count += 1
                i += 1
            else:
                i += 1

def have_n_divisors(n):
    if (have_n_divisors_hash.get(str(n))):
        return have_n_divisors_hash.get(str(n))
    i = 0
    while (True):
        if (n <= count_factor(nth_tri_num(i))):
            return_value = nth_tri_num(i)
            have_n_divisors_hash[str(n)] = return_value
            return return_value
        else:
            i += 1

import unittest
class TestMerge(unittest.TestCase):
    def test_solve(self):
        self.assertEqual(nth_tri_num(4), 10)
        self.assertEqual(count_factor(10), 4)
        self.assertEqual(have_n_divisors(50), 25200)
        self.assertEqual(have_n_divisors(500), 25200)

if __name__ == '__main__':
    unittest.main()

