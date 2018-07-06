package Buildship.Check.FullTestCoverage.Linux.buildTypes

import Buildship.Check.Checkpoints.buildTypes.BasicTestCoverage
import Buildship.EclipseBuildTemplate
import jetbrains.buildServer.configs.kotlin.v2018_1.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_1.FailureAction

object Eclipse48 : BuildType({
    id("Full_Test_Coverage_Linux_Eclipse48_Java8")
    name = "Full Test Coverage (Linux, Eclipse 4.8, Java 8)"

    templates(EclipseBuildTemplate)

    params {
        param("eclipse.version", "48")
        param("compiler.location", "%linux.java8.oracle.64bit%/bin/javac")
        param("eclipse.test.java.home", "%linux.java8.oracle.64bit%")
        param("env.JAVA_HOME", "%linux.java8.oracle.64bit%")
    }

    dependencies {
        snapshot(BasicTestCoverage) {
            onDependencyFailure = FailureAction.CANCEL
            onDependencyCancel = FailureAction.CANCEL
        }
    }

    requirements {
        contains("teamcity.agent.jvm.os.name", "Linux", "RQ_650")
        doesNotEqual("system.agent.name", "ubuntu6-agent1", "RQ_651")
    }
})
