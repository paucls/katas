import unittest

from fibonacci import FibonacciSequence


class FibonacciTest(unittest.TestCase):
    def setUp(self):
        self.fibonacci_sequence = FibonacciSequence()

    def test_first_number_in_sequence_is_0(self):
        number = self.fibonacci_sequence.number_at(0)
        self.assertEqual(0, number)

    def test_second_number_in_sequence_is_1(self):
        number = self.fibonacci_sequence.number_at(1)
        self.assertEqual(1, number)

    def test_fourth_number_in_sequence_is_2(self):
        number = self.fibonacci_sequence.number_at(3)
        self.assertEqual(2, number)

    def test_sixth_number_in_sequence_is_5(self):
        number = self.fibonacci_sequence.number_at(5)
        self.assertEqual(5, number)
