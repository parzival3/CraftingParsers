#!/usr/bin/env bash
set -euo pipefail

rm *.java
rm *.class
javacc Lox.jj
javac *.java
java SyntaxChecker "8 * 3 * (2 + 2345234.22)"
