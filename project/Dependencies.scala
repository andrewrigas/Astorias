import sbt.Keys._
import sbt._

object Dependencies {

  object Versions {
    val scalaz = "7.3.0"
    val cats = "2.0.0"
    val akkaActor = "2.6.5"
    val akkaStreams = "2.6.5"
    val akkaHttp = "10.1.11"
    val logbackClassic = "1.2.3"
    val logbackLogging = "3.9.2"
    val pureconfig = "0.12.3"
    val newType = "0.4.4"
    val scalaCheck = "1.14.3"
    val scalaTest = "3.1.2"
    val scalaTestPlus = "3.1.0.0-RC2"
  }

  object Libraries {
    val scalaz = "org.scalaz"                         %% "scalaz-core"              % Versions.scalaz
    val cats = "org.typelevel"                        %% "cats-core"                % Versions.cats
    val akkaActor = "com.typesafe.akka"               %% "akka-actor"               % Versions.akkaActor
    val akkaActorTyped = "com.typesafe.akka"          %% "akka-actor-typed"         % Versions.akkaActor
    val akkaStream = "com.typesafe.akka"              %% "akka-stream"              % Versions.akkaStreams
    val akkaHttp = "com.typesafe.akka"                %% "akka-http"                % Versions.akkaHttp
    val logbackClassic = "ch.qos.logback"              % "logback-classic"          % Versions.logbackClassic
    val logbackLogging = "com.typesafe.scala-logging" %% "scala-logging"            % Versions.logbackLogging
    val pureConfig = "com.github.pureconfig"          %% "pureconfig"               % Versions.pureconfig
    val newType = "io.estatico"                       %% "newtype"                  % Versions.newType
    val scalaCheck = "org.scalacheck"                 %% "scalacheck"               % Versions.scalaCheck
    val scalaTest = "org.scalatest"                   %% "scalatest"                % Versions.scalaTest
    val scalaTestPlus = "org.scalatestplus"           %% "scalatestplus-scalacheck" % Versions.scalaTestPlus
  }

  private lazy val logging = Seq(
    Libraries.logbackClassic,
    Libraries.logbackLogging
  )

  private lazy val utils = Seq(
    Libraries.pureConfig
  )

  private lazy val test = Seq(
    Libraries.scalaTest     % Test,
    Libraries.scalaTestPlus % Test,
    Libraries.scalaCheck    % Test
  )

  lazy val scalaz = libraryDependencies ++= utils ++ logging ++ Seq(Libraries.scalaz)

  lazy val cats = libraryDependencies ++= utils ++ logging ++ Seq(Libraries.cats)

  lazy val akka = libraryDependencies ++= utils ++ logging ++ Seq(
    Libraries.akkaActor,
    Libraries.akkaStream,
    Libraries.akkaHttp,
    Libraries.akkaActorTyped
  )

  lazy val propertyTest = libraryDependencies ++= test

  lazy val opaque = libraryDependencies ++= utils ++ logging ++ Seq(Libraries.newType)
}
