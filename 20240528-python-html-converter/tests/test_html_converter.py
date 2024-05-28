from io import StringIO

from html_converter import HtmlConverter

converter = HtmlConverter()


def test_html_converter_uses_valid_html_tags():
    fake_file = StringIO("")

    html = converter.convert_file_to_html(fake_file)

    assert html == "<html></html>"


def test_html_converter_uses_valid_paragraph_tags():
    fake_file = StringIO("line 1\nline 2")

    html = converter.convert_file_to_html(fake_file)

    assert html == "<html><p>line 1</p><p>line 2</p></html>"


class StubEmptyFile:
    def __iter__(self):
        return self

    def __next__(self):
        raise StopIteration


class StubTwoLineFile:
    def __init__(self):
        self.current = -1

    def __iter__(self):
        return self

    def __next__(self):
        self.current += 1
        if self.current == 0:
            return " line 1\n"
        if self.current == 1:
            return " line 2  \n"
        raise StopIteration
