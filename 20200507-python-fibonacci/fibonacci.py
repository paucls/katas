class FibonacciSequence(object):
    def at_index(self, index):
        if index <= 1:
            return index
        else:
            return index - 1
