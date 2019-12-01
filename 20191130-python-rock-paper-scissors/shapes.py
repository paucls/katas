import abc


class Shape:
    @abc.abstractmethod
    def beats(self, shape):
        pass


class Paper(Shape):
    def beats(self, shape: Shape):
        return isinstance(shape, Rock)


class Rock(Shape):
    def beats(self, shape: Shape):
        return isinstance(shape, Scissors)


class Scissors(Shape):
    def beats(self, shape: Shape):
        return isinstance(shape, Paper)
