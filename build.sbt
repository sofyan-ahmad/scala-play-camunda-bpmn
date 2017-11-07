name := """play-scala-starter-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1206-jdbc41"
libraryDependencies += "org.camunda.bpm" % "camunda-bom" % "7.7.0"
libraryDependencies += "org.camunda.bpm" % "camunda-engine" % "7.7.0"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "com.h2database" % "h2" % "1.4.196"
