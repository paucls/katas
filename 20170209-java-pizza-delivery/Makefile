MVN	?= ./dep/apache-maven-3.3.3/bin/mvn

all: dependencies test

clean:
	@$(MVN) -q clean
	@rm -rf ./target
	$(RM) classes/**/*.class

test:
	@$(MVN) -q clean test

dependencies:
	@if [ -z ${JAVA_HOME} ]; then echo "JAVA_HOME is unset..."; else echo "JAVA_HOME is set to ${JAVA_HOME}"; fi
	@$(MVN) -q clean

.PHONY: all dependencies test
