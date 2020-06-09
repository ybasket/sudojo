name := "sudojo"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= List(
  compilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full),
  compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
  compilerPlugin("io.tryp" % "splain" % "0.5.6" cross CrossVersion.patch),
  "org.typelevel" %% "cats-core" % "2.2.0-M2",
  "org.typelevel" %% "mouse" % "0.25",
  "co.fs2" %% "fs2-core" % "2.4.0",
  "org.scalatest" %% "scalatest" % "3.1.0" % Test
)
