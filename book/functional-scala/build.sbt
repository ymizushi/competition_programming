lazy val root = (project in file(".")).
  settings(
    name := "functional-scala",
    version := "1.0",
    scalaVersion := "2.11.4"
  )


libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6.1" % "test")

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")
