name := "es-query-engine"

version := "0.1"

scalaVersion := "2.12.7"


libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "2.0.0",
  "com.typesafe" % "config" % "1.3.3",
  "org.elasticsearch.client" % "transport" % "6.4.2",
  "com.typesafe.akka" %% "akka-actor" % "2.5.17",
  "org.reactivemongo" %% "reactivemongo" % "0.16.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "org.json4s" %% "json4s-native" % "3.6.1",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.17" % Test
)
