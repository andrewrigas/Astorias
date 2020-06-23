import sbt.Keys._

object ScalacOptions {

  val inCompile = scalacOptions ++=
    Seq(
      "-Yrangepos", // required by SemanticDB compiler plugin
      "-Wunused:imports", // required by `RemoveUnused` rule
      "-Ymacro-annotations" //Enable Macro-paradise
    )

}
