class Paper:
    def beats(self, shape):
        return isinstance(shape, Rock)


class Rock:
    def beats(self, shape):
        return isinstance(shape, Scissors)


class Scissors:
    pass
