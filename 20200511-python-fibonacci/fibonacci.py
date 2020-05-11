class FibonacciSequence(object):
    def number_at(self, index):
        if index <= 1:
            return index
        else:
            return self.number_at(index - 1) + self.number_at(index - 2)
