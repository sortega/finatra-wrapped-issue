lazy val versions = new {
  val finatra = "18.7.0"
  val guice = "4.1.0"
  val logback = "1.1.7"
  val mockito = "1.9.5"
  val scalatest = "3.0.0"
}

lazy val root = (project in file(".")).settings(
  scalaVersion := "2.12.4",
  name := "finatra-wrapped-issue",
  libraryDependencies ++= Seq(
    "ch.qos.logback" % "logback-classic" % versions.logback,
    "com.google.inject.extensions" % "guice-testlib" % versions.guice % Test classifier "tests",
    "com.google.inject.extensions" % "guice-testlib" % versions.guice % Test,
    "com.twitter" %% "finatra-http" % versions.finatra % Test classifier "tests",
    "com.twitter" %% "finatra-http" % versions.finatra,
    "com.twitter" %% "finatra-jackson" % versions.finatra % Test classifier "tests",
    "com.twitter" %% "finatra-jackson" % versions.finatra % Test,
    "com.twitter" %% "finatra-utils" % versions.finatra % Test classifier "tests",
    "com.twitter" %% "finatra-utils" % versions.finatra % Test,
    "com.twitter" %% "inject-app" % versions.finatra % Test classifier "tests",
    "com.twitter" %% "inject-app" % versions.finatra % Test,
    "com.twitter" %% "inject-core" % versions.finatra % Test classifier "tests",
    "com.twitter" %% "inject-core" % versions.finatra % Test,
    "com.twitter" %% "inject-modules" % versions.finatra % Test classifier "tests",
    "com.twitter" %% "inject-modules" % versions.finatra % Test,
    "com.twitter" %% "inject-server" % versions.finatra % Test classifier "tests",
    "com.twitter" %% "inject-server" % versions.finatra % Test,
    "org.mockito" % "mockito-core" %  versions.mockito % Test,
    "org.scalatest" %% "scalatest" % versions.scalatest % Test
  )
)
