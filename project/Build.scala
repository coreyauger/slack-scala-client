import sbt._
import Keys._
import com.typesafe.sbt.SbtPgp.autoImport._
import sbtrelease._

object BuildSettings {
  val buildOrganization = "im.conversant"
  val buildVersion      = "0.1.8"
  val buildScalaVersion = "2.11.8"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization := buildOrganization,
    version      := buildVersion,
    scalaVersion := buildScalaVersion,
    //publishMavenStyle := true,
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
    publishTo := {
      Some("NextWave Repo" at "http://maxdevmaster.cloudapp.net:4343/artifactory/nxtwv-maven/")
    }
  )
}

object Resolvers {
  val typesafeRepo = "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
  val nxtwvReop = "NextWave Repo" at "http://maxdevmaster.cloudapp.net:4343/artifactory/nxtwv-maven/"
}

object Dependencies {
  val akkaVersion = "2.4.8"
  val sprayVersion = "1.3.3"
  val playVersion = "2.4.6"

  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % akkaVersion

  val scalaAsync = "org.scala-lang.modules" %% "scala-async" % "0.9.5"
  val dispatch = "net.databinder.dispatch" %% "dispatch-core" % "0.11.3"
  val playJson = "com.typesafe.play" %% "play-json" % playVersion
  val playWS = "com.typesafe.play" %% "play-ws" % playVersion

  val sprayWebsocket = "com.wandoulabs.akka" %% "spray-websocket" % "0.1.4"

  val scalatest = "org.scalatest" %% "scalatest" % "2.2.1" % "test"

  val akkaDependencies = Seq(akkaActor, akkaSlf4j)
  val miscDependencies = Seq(playWS, playJson, scalaAsync, dispatch, sprayWebsocket)
  val testDependencies = Seq(scalatest)

  val allDependencies = akkaDependencies ++ miscDependencies ++ testDependencies
}

object SlackScalaClient extends Build {
  import Resolvers._
  import BuildSettings._
  import Defaults._

  lazy val slackScalaClient =
    Project ("slack-scala-client", file("."))
      .settings ( buildSettings : _* )
      .settings ( resolvers ++= Seq(typesafeRepo, nxtwvReop) )
      .settings ( libraryDependencies ++= Dependencies.allDependencies )
      .settings ( dependencyOverrides += "io.spray" %% "spray-can" % Dependencies.sprayVersion)
      .settings ( scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xlint", "-Xfatal-warnings", "-feature") )

}
