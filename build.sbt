ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.1"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaTutorial",
//    idePackagePrefix := Some("com.app.learning")
  )


ThisBuild / scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")

ThisBuild / libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test