name := "scala_course"

version := "0.1"

scalaVersion := "2.12.8"

maxErrors := 5

val ZIOVersion = "1.0-RC4"
val scalazVersion = "7.2.27"
val simulaVersion = "0.16.0"
val scalacheckVersion = "1.14.0"

scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-language:_",
    "-Ypartial-unification",
    "-Xfatal-warnings"
)

libraryDependencies ++= Seq(
  "com.github.mpilquist"  %% "simulacrum" % simulaVersion,
  "org.scalaz" %% "scalaz-zio" % ZIOVersion,
  "org.scalacheck" %% "scalacheck" % scalacheckVersion,
  "org.scalaz" %% "scalaz-core" % scalazVersion
)