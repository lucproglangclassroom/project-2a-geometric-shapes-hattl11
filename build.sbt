name := "shapes-oo-scala"

version := "0.4"

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle"     % "0.30.0",
  "org.scalatest"     %% "scalatest"  % "3.2.19"  % Test,
  "org.scalacheck"    %% "scalacheck" % "1.18.1"  % Test,
  "org.slf4j"          % "slf4j-simple" % "2.0.12"
)
