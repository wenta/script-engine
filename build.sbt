name := "script-engine"

version := "0.1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.9",
  "com.carl" %% "flow-script" % "0.1.0"
)
