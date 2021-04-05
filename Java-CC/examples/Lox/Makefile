
.PHONY: test
test: SyntaxChecker.class
	java SyntaxChecker "8 * 3 * (2 + 2345234.22) * ("true")"

SyntaxChecker.java: Lox.jj
	rm -rf *.java *.class
	javacc Lox.jj

SyntaxChecker.class: SyntaxChecker.java
	javac *.java

