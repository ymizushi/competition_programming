#!/usr/bin/env python
# -*- coding: utf-8 -*-
import math
import unittest

def is_prime(n):
    if n is 1:
        return False
    elif n is 2:
        return True
    counter = 2
    while counter <= int(math.sqrt(n)):
        if n % counter is 0:
            return False
        counter += 1
    return True

def max_prime_factor(prime_list, max_range):
    counter = 2
    while counter <= max_range:
        if max_range % counter == 0 and is_prime(counter):
            max_range /= counter
            prime_list += [counter]
            counter = 2
            continue
        counter += 1
    return max(prime_list)

class TestMerge(unittest.TestCase):
    def test_solve(self):
        primes = []
        max_range = 600851475143

        expected = 6857 
        self.assertEqual(max_prime_factor(primes, max_range), expected)

if __name__ == '__main__':
    unittest.main()
