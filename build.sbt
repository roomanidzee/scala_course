name := "scala_course"

version := "0.1"

scalaVersion := "2.12.8"

maxErrors := 5

scalacOptions ++= Seq(
  "-language:_",
  "-Ypartial-unification",
  "-Xfatal-warnings")

libraryDependencies ++= Seq(
  "com.github.mpilquist"  %% "simulacrum" % "0.16.0",
  "org.scalaz" %% "scalaz-zio" % "1.0-RC4",
  "org.scalacheck" %% "scalacheck" % "1.14.0"
)