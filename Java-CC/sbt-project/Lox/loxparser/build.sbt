val scala3Version = "3.0.0-RC2"
val proj_version = "0.1.0"


lazy val ast = project.settings (
    version := proj_version,
    scalaVersion := scala3Version,
)

lazy val javacc = project.dependsOn(ast).aggregate(ast).enablePlugins(JavaCCPlugin).settings (
    version := proj_version,
    scalaVersion := scala3Version,
)

lazy val test_tree = project.dependsOn(javacc, ast).aggregate(ast, javacc)
  .in(file("."))
  .settings (
    name := "javcc-scala",
    version := proj_version,
    scalaVersion := scala3Version,
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
)
