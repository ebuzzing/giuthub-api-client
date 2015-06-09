//Revolver.settings

scalaVersion := "2.11.6"

resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += Resolver.sonatypeRepo("releases")
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
//resolvers += "JTO snapshots" at "https://raw.github.com/jto/mvn-repo/master/snapshots"

val akkaVersion = "2.3.11"
val Akka = Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
)

libraryDependencies ++= Akka
// Typesafe Config and friends
libraryDependencies += "net.ceedubs" %% "ficus" % "1.1.2"
libraryDependencies += "io.spray" %% "spray-client" % "1.3.2"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.3.9"
libraryDependencies += "io.github.jto" %% "validation-core" % "1.0.1"
libraryDependencies += "io.github.jto" %% "validation-json" % "1.0.1"
libraryDependencies += "org.yaml" % "snakeyaml" % "1.15"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.13"

libraryDependencies += "com.chuusai" %% "shapeless" % "2.2.1"



libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.5" % "test"
