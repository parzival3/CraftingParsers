
.PHONY: test

test: SyntaxChecker.class
	java SyntaxChecker "8 * 3 * (2 + 2345234.22) * ("true")"



SyntaxChecker.java: Expr.java
	javacc Lox.jj

Expr.java: Lox.jj
	rm -rf *.java *.class
	curl --output TokenType.java https://raw.githubusercontent.com/munificent/craftinginterpreters/master/java/com/craftinginterpreters/lox/TokenType.java
	curl --output Expr.java https://raw.githubusercontent.com/munificent/craftinginterpreters/master/java/com/craftinginterpreters/lox/Expr.java
	sed -i '' -e '1,3d' Expr.java
	sed -i '' -e '1,3d' TokenType.java
	sed -i '' 's/Token/TokenType/g' Expr.java

SyntaxChecker.class: SyntaxChecker.java
	javac *.java


clean:
	rm -rf *.java
	rm -rf *.class
