Add unit tests for new features.
When you implement production code, make sure of running tests to check all works.
Use AssertJ for assertions.
If a feature introduces changes for a class that has no previous tests. Before adding new functionality, add regression tests for the rest of the class too.
When a new model or data class is added, make sure is in a separated file.

After you change any code, make sure the .windsurf/scripts/checkstyle_gate.py script does not fail. If any issue is reported fix the code before finishing.