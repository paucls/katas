class FibonacciSequence(object):
    def number_at(self, index):
        if index <= 1:
            return index
        else:
            return index - 1
