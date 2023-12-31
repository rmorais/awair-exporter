val scala3Version = "3.3.1"
val http4sVersion = "0.23.24"
val circeVersion = "0.14.6"

// Compile / run / fork := true


scalacOptions ++= Seq(
  "-deprecation",                     // Emit warning and location for usages of deprecated APIs.
  "-Xfatal-warnings",                 // Fail the compilation if there are any warnings.
  "-Wunused:all"                      // Emit compilation warnings for all unused code
)
lazy val root = project
  .in(file("."))
  .settings(
    name := "awair-exporter",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-testing" % circeVersion,
      "ch.qos.logback" % "logback-classic" % "1.4.9",
      "org.typelevel" %% "cats-core" % "2.10.0",
      "org.typelevel" %% "cats-effect" % "3.5.2",
      "org.http4s" %% "http4s-ember-client" % http4sVersion,
      "org.http4s" %% "http4s-dsl" % http4sVersion,
      "org.http4s" %% "http4s-circe" % http4sVersion,
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.typelevel" %% "discipline-munit" % "2.0.0-M3" % Test
    )
  )
