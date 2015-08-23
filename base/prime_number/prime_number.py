#!/usr/bin/env python
# -*- coding: utf-8 -*-
import unittest

def is_prime_num(n):
    count = 0
    for i in range(1,n+1):
        if n % i == 0:
            count += 1
    if count == 2:
        return True
    else:
        return False

def count_prime_number(n):
    count = 0
    for i in range(2, n):
        if is_prime_num(i):
            count += 1
    return count

class TestPrimeNumber(unittest.TestCase):
    def test_is_prime_num(self):
        for n in [2, 3, 5, 7, 11, 13, 17, 19]:
            self.assertTrue(is_prime_num(n))
        for n in [1, 4, 6, 8, 9, 10, 12, 14 ,15 ,16, 18, 20]:
            self.assertFalse(is_prime_num(n))

        import time
        start_time = time.time()
        for i in range(20000):
            is_prime_num(i)
        print(time.time() - start_time)

    def test_count_prime_number(self):
        self.assertEqual(4, count_prime_number(10))
        self.assertEqual(8, count_prime_number(20))
if __name__ == '__main__':
    unittest.main()


