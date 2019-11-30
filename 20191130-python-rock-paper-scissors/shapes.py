class Paper:
    def beats(self, shape):
        return isinstance(shape, Rock)


class Rock:
    def beats(self, shape):
        return True


class Scissors:
    pass
