import unittest
from p4 import P4

class TestP4(unittest.TestCase):
    def setUp(self):
        self.p4 = P4('test_data.txt')
        self.p4_test1 = P4('test_data1.txt')

    def test_solve(self):
        self.assertEqual(self.p4.calc_all(), 465) # A. 348
        self.assertEqual(self.p4_test1.calc_all(), 3)

if __name__ == '__main__':
    unittest.main()
