import unittest

from fibonacci import FibonacciSequence


class FibonacciTest(unittest.TestCase):

    def test_first_number_in_sequence_is_0(self):
        number = FibonacciSequence().at_index(0)
        self.assertEqual(0, number)
