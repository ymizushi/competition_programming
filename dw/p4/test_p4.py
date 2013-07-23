import unittest
from p4 import P4

class TestP4(unittest.TestCase):
    def setUp(self):
        self.p4 = P4()

    def test_solve(self):
        self.assertEqual(self.p4.calc_all(), 467)

if __name__ == '__main__':
    unittest.main()
