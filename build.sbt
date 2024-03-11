val shared = Seq(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test,
  testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oD"),
)

val foo = project.in(file("foo")).settings(
  name := "foo",
  shared
)

val bar = project.in(file("bar")).settings(
  name := "bar",
  shared
)

Global / concurrentRestrictions += Tags.limit(Tags.Test, 1)
