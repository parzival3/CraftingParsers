
def prettyPrint(expression: Expr): String =
  expression match
    case Binary(l, t, r) => s"(${t} ${prettyPrint(l)}  ${prettyPrint(r)})"
    case Unary(t, e) => s"(${t} ${prettyPrint(e)})"
    case Grouping(e) => s"(group ${prettyPrint(e)})"
    case Literal(v) => s"$v"

@main def main(args: String) = {
        val hello: SyntaxChecker = new SyntaxChecker(new java.io.StringReader(args));
        val out = SyntaxChecker.expression()
        println(prettyPrint(out))
}
