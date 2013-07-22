import unittest
from p4 import __main__ as cal

class TestP4(unittest.TestCase):
    def setUp(self):
        pass

    def test_solve(self):
        self.assertEqual(cal(), 467)

if __name__ == '__main__':
    unittest.main()
