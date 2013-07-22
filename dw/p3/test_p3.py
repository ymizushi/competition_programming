import unittest
from p3 import *

class TestP3(unittest.TestCase):
    def setUp(self):
        self.test_data =  parse('test_data.txt')
        self.s = map(lambda x: int(x), test_data.get('s'))
        self.t = map(lambda x: int(x), test_data.get('t'))
        self.all_st = range(min(s + t),max(s+t))
        self.t_s = sorted(map(lambda x: range(x[0], x[1]), zip(s, t)), key=lambda x:len(x))

    def test_solve(self):
        self.assertEqual(calc(self.t_s, all_st, 0),10)

if __name__ == '__main__':
    unittest.main()
