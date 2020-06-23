ThisBuild / name := "Astorias"
ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.13.2"

ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

lazy val root = Projects.root.aggregate(projects: _*)

lazy val scalaz = Projects.scalaz
  .settings(Dependencies.scalaz)

lazy val cats = Projects.cats
  .settings(Dependencies.cats)

lazy val akka = Projects.akka
  .settings(Dependencies.akka)

lazy val opaque = Projects.opaque
  .settings(Dependencies.opaque)

lazy val properties = Projects.properties
  .settings(Dependencies.propertyTest)

lazy val projects: Seq[ProjectReference] = Seq(scalaz, cats, akka)
