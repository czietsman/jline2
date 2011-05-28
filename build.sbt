name := "jline"

organization := "org.scala-lang"

version := "2.10.0-SNAPSHOT"

scalaVersion := "2.9.0-1"

// Only need these because of weird testing jline issues.
retrieveManaged := true

libraryDependencies ++= Seq(
	"org.fusesource.jansi" % "jansi" % "1.4",
	"com.novocode" % "junit-interface" % "0.5" % "test->default"
)

javacOptions ++= Seq("-target", "1.5")

seq(ProguardPlugin.proguardSettings :_*)

proguardOptions ++= Seq(
  "-dontshrink",
  "-keep class *",
  "-keepdirectories"
)

proguardInJars := Nil

makeInJarFilter <<= (makeInJarFilter) {
  (makeInJarFilter) => {
    (file) => {
      if (!file.startsWith("jansi")) makeInJarFilter(file)
      else List(
        "!META-INF/MANIFEST.MF",
        "org/fusesource/hawtjni/runtime",
        "org/fusesource/hawtjni/runtime/Callback.class",
        "org/fusesource/hawtjni/runtime/Library.class",
        "!org/fusesource/hawtjni/**",
        "!META-INF/maven/org.fusesource.hawtjni",
        "!META-INF/maven/org.fusesource.jansi",
        "!META-INF/maven/org.fusesource.hawtjni/**",
        "!META-INF/maven/org.fusesource.jansi/**"
      ).mkString(", ")
    }
  }
}
