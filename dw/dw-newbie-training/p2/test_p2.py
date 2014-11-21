import unittest
from p2 import P2

class TestP2(unittest.TestCase):
    def setUp(self):
        pass

    def test_solve(self):
        self.p2 = P2('test_data.txt')
        self.assertEqual(self.p2.calc(), 22)

if __name__ == '__main__':
    unittest.main()
