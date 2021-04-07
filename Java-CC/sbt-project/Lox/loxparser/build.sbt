val scala3Version = "3.0.0-RC2"
val proj_version = "0.1.0"

lazy val scala_ast = project.in(file("ast/")).settings (
    version := proj_version,
    scalaVersion := scala3Version,
)

lazy val javacc_sources = project.in(file("javacc/")).enablePlugins(JavaCCPlugin).settings (
    version := proj_version,
    scalaVersion := scala3Version,
).dependsOn(scala_ast)

lazy val root = project
  .in(file("."))
  .settings (
    name := "scala3-simple",
    version := proj_version,
    scalaVersion := scala3Version,
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
).dependsOn(javacc_sources)
