name := """play-sandbox"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc" % "3.2.3",
  "org.scalikejdbc" %% "scalikejdbc-config" % "3.2.3",
  "org.scalikejdbc" %% "scalikejdbc-test" % "3.2.3" % Test,
  "org.scalikejdbc" %% "scalikejdbc-syntax-support-macro" % "3.2.+",
  "org.skinny-framework" %% "skinny-orm" % "2.3.7",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.6.+",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "mysql" % "mysql-connector-java" % "6.0.6",
  "com.adrianhurt" %% "play-bootstrap" % "1.2-P26-B3"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"
TwirlKeys.templateImports += "forms._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
