import unittest

from fibonacci import FibonacciSequence


class FibonacciTest(unittest.TestCase):

    def test_first_number_in_sequence_is_0(self):
        number = FibonacciSequence().at_index(0)
        self.assertEqual(0, number)

    def test_second_number_in_sequence_is_1(self):
        number = FibonacciSequence().at_index(1)
        self.assertEqual(1, number)

    def test_fourth_number_in_sequence_is_2(self):
        number = FibonacciSequence().at_index(3)
        self.assertEqual(2, number)
