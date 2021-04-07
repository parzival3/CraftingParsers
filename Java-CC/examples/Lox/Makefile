SCALA_CC_DEPS=TokenType.scala Expr.scala
SCALAC=scala3-compiler

.PHONY: test


target/dependencies.list: Maven.list
	mkdir -p target
	cs fetch $(shell sed '/^#/d' Maven.list) > $@

target/classpath.line: target/dependencies.list
	paste -s -d ':' $^ > $@

target/classfiles.stamp: $(SCALA_CC_DEPS) target/classpath.line
	@mkdir -p target/classfiles
	@${SCALAC} -explain \
	  -d target/ \
	  -cp $(shell cat target/classpath.line) \
	$(SCALA_CC_DEPS)
	touch target/classfiles.stamp

SyntaxChecker.java: target/classfiles.stamp Lox.jj
	javacc Lox.jj

target/SyntaxChecker.class: SyntaxChecker.java
	@javac -d target/ \
		-cp $(shell cat target/classpath.line):./target/ \
		*.java

target/main.class: target/SyntaxChecker.class
	@${SCALAC} -explain \
	  -d target/ \
	  -cp $(shell cat target/classpath.line):target/ \
	PrettyPrint.scala

test: target/main.class
	@java -cp $(shell cat target/classpath.line):target/ main  "8 * 3 * (2 + 2345234.22) * ("true")"

clean:
	rm -rf target/
