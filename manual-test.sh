#!/usr/bin/env bash
#
# Apparently the jline bundled with sbt interferes with testing some
# changes: for instance after changing the keybindings I kept seeing
# failures until I realized what was happening and bypassed sbt, like this.

java -cp \
lib/jansi-1.6.jar:lib_managed/jar/com.novocode/junit-interface/junit-interface-0.7.jar:lib_managed/jar/junit/junit/junit-4.8.2.jar:lib_managed/jar/org.scala-tools.testing/test-interface/test-interface-0.5.jar:target/scala-2.9.0.1/classes:target/scala-2.9.0.1/test-classes \
org.junit.runner.JUnitCore scala.tools.jline.console.EditLineTest
