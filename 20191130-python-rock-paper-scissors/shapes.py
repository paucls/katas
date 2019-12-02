import abc


class Shape:
    @abc.abstractmethod
    def beats(self, shape):
        pass

    def is_a(self, another_shape):
        return isinstance(self, another_shape)


class Paper(Shape):
    def beats(self, shape: Shape):
        return shape.is_a(Rock)


class Rock(Shape):
    def beats(self, shape: Shape):
        return shape.is_a(Scissors)


class Scissors(Shape):
    def beats(self, shape: Shape):
        return shape.is_a(Paper)


class Spock(Shape):
    def beats(self, shape: Shape):
        return shape.is_a(Scissors) or shape.is_a(Rock)
