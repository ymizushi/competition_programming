import unittest
from p3 import GreedMethod

class TestGreedMethod(unittest.TestCase):
    def setUp(self):
        self.greed_method = GreedMethod('test_data.txt')

    def test_solve(self):
        self.assertEqual(self.greed_method.calc(self.greed_method.t_s, self.greed_method.all_st, 0), 10)

if __name__ == '__main__':
    unittest.main()
