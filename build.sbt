name := "es-stateful-query-engine"

version := "0.1"

scalaVersion := "2.12.7"


libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.3",
  "org.elasticsearch.client" % "transport" % "6.4.2",
  "com.typesafe.akka" %% "akka-actor" % "2.5.17",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "org.json4s" %% "json4s-native" % "3.6.1",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.17" % Test
)
