import sbt._

object Projects {

  private def createModule(moduleId: String) = {
    Project(id = moduleId, base = file(moduleId))
      .settings(Aliases.commonAliases)
      .settings(ScalacOptions.inCompile)
  }

  lazy val root = Project("Astorias", base = file("."))

  lazy val scalaz = createModule("scalaz")

  lazy val cats = createModule("cats")

  lazy val akka = createModule("akka")

  lazy val opaque = createModule("opaque")

  lazy val properties = createModule("properties")
}
