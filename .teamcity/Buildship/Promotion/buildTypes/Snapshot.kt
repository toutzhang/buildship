package Buildship.Promotion.buildTypes

import Buildship.Check.Checkpoints.buildTypes.Final
import Buildship.GitHubVcsRoot
import jetbrains.buildServer.configs.kotlin.v2018_1.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_1.CheckoutMode
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.schedule

object Snapshot : BuildType({
    id("Promote_Snapshot")
    name = "Promote Snapshot"

    artifactRules = "org.eclipse.buildship.site/build/repository/** => update-site"

    params {
        param("env.JAVA_HOME", "%linux.java8.oracle.64bit%")
        param("eclipse.release.type", "snapshot")
        param("build.invoker", "ci")
    }

    vcs {
        root(GitHubVcsRoot)

        checkoutMode = CheckoutMode.ON_AGENT
        cleanCheckout = true
        showDependenciesChanges = true
    }

    steps {
        gradle {
            name = "Build and upload update site for Eclipse 4.2 (Juno)"
            tasks = "clean build uploadUpdateSite"
            buildFile = ""
            gradleParams = """
                --exclude-task eclipseTest
                -Peclipse.version=42 -Pcompiler.location='%linux.java7.oracle.64bit%/bin/javac' -Pbuild.invoker=%build.invoker% -Prelease.type=%eclipse.release.type% -PECLIPSE_ORG_FTP_HOST=build.eclipse.org -PECLIPSE_ORG_FTP_USER=%eclipse.downloadServer.username% -PECLIPSE_ORG_FTP_PASSWORD=%eclipse.downloadServer.password% -PECLIPSE_ORG_FTP_UPDATE_SITES_PATH=/home/data/httpd/download.eclipse.org/buildship/updates -PECLIPSE_ORG_TEMP_PATH=/home/data/httpd/download.eclipse.org/buildship/temp -PECLIPSE_ORG_MIRROR_PATH=/buildship/updates
                --stacktrace -Declipse.p2.mirror=false
            """.trimIndent()
            param("org.jfrog.artifactory.selectedDeployableServer.defaultModuleVersionConfiguration", "GLOBAL")
        }
        gradle {
            name = "Build and upload update site for Eclipse 4.3 (Kepler)"
            tasks = "clean build uploadUpdateSite"
            buildFile = ""
            gradleParams = """
                --exclude-task eclipseTest
                -Peclipse.version=43 -Pcompiler.location='%linux.java7.oracle.64bit%/bin/javac' -Pbuild.invoker=%build.invoker% -Prelease.type=%eclipse.release.type% -PECLIPSE_ORG_FTP_HOST=build.eclipse.org -PECLIPSE_ORG_FTP_USER=%eclipse.downloadServer.username% -PECLIPSE_ORG_FTP_PASSWORD=%eclipse.downloadServer.password% -PECLIPSE_ORG_FTP_UPDATE_SITES_PATH=/home/data/httpd/download.eclipse.org/buildship/updates -PECLIPSE_ORG_TEMP_PATH=/home/data/httpd/download.eclipse.org/buildship/temp -PECLIPSE_ORG_MIRROR_PATH=/buildship/updates
                --stacktrace -Declipse.p2.mirror=false
            """.trimIndent()
            param("org.jfrog.artifactory.selectedDeployableServer.defaultModuleVersionConfiguration", "GLOBAL")
        }
        gradle {
            name = "Build and upload update site for Eclipse 4.4 (Luna)"
            tasks = "clean build uploadUpdateSite"
            buildFile = ""
            gradleParams = """
                --exclude-task eclipseTest
                -Peclipse.version=44 -Pcompiler.location='%linux.java7.oracle.64bit%/bin/javac' -Pbuild.invoker=%build.invoker% -Prelease.type=%eclipse.release.type% -PECLIPSE_ORG_FTP_HOST=build.eclipse.org -PECLIPSE_ORG_FTP_USER=%eclipse.downloadServer.username% -PECLIPSE_ORG_FTP_PASSWORD=%eclipse.downloadServer.password% -PECLIPSE_ORG_FTP_UPDATE_SITES_PATH=/home/data/httpd/download.eclipse.org/buildship/updates -PECLIPSE_ORG_TEMP_PATH=/home/data/httpd/download.eclipse.org/buildship/temp -PECLIPSE_ORG_MIRROR_PATH=/buildship/updates
                --stacktrace -Declipse.p2.mirror=false
            """.trimIndent()
            param("org.jfrog.artifactory.selectedDeployableServer.defaultModuleVersionConfiguration", "GLOBAL")
        }
        gradle {
            name = "Build and upload update site for Eclipse 4.5 (Mars)"
            tasks = "clean build uploadUpdateSite"
            buildFile = ""
            gradleParams = """
                --exclude-task eclipseTest
                -Peclipse.version=45 -Pcompiler.location='%linux.java7.oracle.64bit%/bin/javac' -Pbuild.invoker=%build.invoker% -Prelease.type=%eclipse.release.type% -PECLIPSE_ORG_FTP_HOST=build.eclipse.org -PECLIPSE_ORG_FTP_USER=%eclipse.downloadServer.username% -PECLIPSE_ORG_FTP_PASSWORD=%eclipse.downloadServer.password% -PECLIPSE_ORG_FTP_UPDATE_SITES_PATH=/home/data/httpd/download.eclipse.org/buildship/updates -PECLIPSE_ORG_TEMP_PATH=/home/data/httpd/download.eclipse.org/buildship/temp -PECLIPSE_ORG_MIRROR_PATH=/buildship/updates
                --stacktrace -Declipse.p2.mirror=false
            """.trimIndent()
            param("org.jfrog.artifactory.selectedDeployableServer.defaultModuleVersionConfiguration", "GLOBAL")
        }
        gradle {
            name = "Build and upload update site for Eclipse 4.6 (Neon)"
            tasks = "clean build uploadUpdateSite"
            buildFile = ""
            gradleParams = """
                --exclude-task eclipseTest
                -Peclipse.version=46 -Pcompiler.location='%linux.java8.oracle.64bit%/bin/javac' -Pbuild.invoker=%build.invoker% -Prelease.type=%eclipse.release.type% -PECLIPSE_ORG_FTP_HOST=build.eclipse.org -PECLIPSE_ORG_FTP_USER=%eclipse.downloadServer.username% -PECLIPSE_ORG_FTP_PASSWORD=%eclipse.downloadServer.password% -PECLIPSE_ORG_FTP_UPDATE_SITES_PATH=/home/data/httpd/download.eclipse.org/buildship/updates -PECLIPSE_ORG_TEMP_PATH=/home/data/httpd/download.eclipse.org/buildship/temp -PECLIPSE_ORG_MIRROR_PATH=/buildship/updates
                --stacktrace -Declipse.p2.mirror=false
            """.trimIndent()
            param("org.jfrog.artifactory.selectedDeployableServer.defaultModuleVersionConfiguration", "GLOBAL")
        }
        gradle {
            name = "Build and upload update site for Eclipse 4.7 (Oxygen)"
            tasks = "clean build uploadUpdateSite"
            buildFile = ""
            gradleParams = """
                --exclude-task eclipseTest
                -Peclipse.version=47 -Pcompiler.location='%linux.java8.oracle.64bit%/bin/javac' -Pbuild.invoker=%build.invoker% -Prelease.type=%eclipse.release.type% -PECLIPSE_ORG_FTP_HOST=build.eclipse.org -PECLIPSE_ORG_FTP_USER=%eclipse.downloadServer.username% -PECLIPSE_ORG_FTP_PASSWORD=%eclipse.downloadServer.password% -PECLIPSE_ORG_FTP_UPDATE_SITES_PATH=/home/data/httpd/download.eclipse.org/buildship/updates -PECLIPSE_ORG_TEMP_PATH=/home/data/httpd/download.eclipse.org/buildship/temp -PECLIPSE_ORG_MIRROR_PATH=/buildship/updates
                --stacktrace -Declipse.p2.mirror=false
            """.trimIndent()
            param("org.jfrog.artifactory.selectedDeployableServer.defaultModuleVersionConfiguration", "GLOBAL")
        }
        gradle {
            name = "Build and upload update site for Eclipse 4.8 (Photon)"
            tasks = "clean build uploadUpdateSite"
            buildFile = ""
            gradleParams = """
                --exclude-task eclipseTest
                -Peclipse.version=48 -Pcompiler.location='%linux.java8.oracle.64bit%/bin/javac' -Pbuild.invoker=%build.invoker% -Prelease.type=%eclipse.release.type% -PECLIPSE_ORG_FTP_HOST=build.eclipse.org -PECLIPSE_ORG_FTP_USER=%eclipse.downloadServer.username% -PECLIPSE_ORG_FTP_PASSWORD=%eclipse.downloadServer.password% -PECLIPSE_ORG_FTP_UPDATE_SITES_PATH=/home/data/httpd/download.eclipse.org/buildship/updates -PECLIPSE_ORG_TEMP_PATH=/home/data/httpd/download.eclipse.org/buildship/temp -PECLIPSE_ORG_MIRROR_PATH=/buildship/updates
                --stacktrace -Declipse.p2.mirror=false
            """.trimIndent()
        }
    }

    triggers {
        schedule {
            schedulingPolicy = daily {
                hour = 23
            }
            branchFilter = """
                +:<default>
                +:release-3.0
            """.trimIndent()
            triggerRules = """
                -:docs/**
                -:README.MD
            """.trimIndent()
            triggerBuild = always()
            enforceCleanCheckout = true
            param("revisionRule", "lastFinished")
            param("dayOfWeek", "Sunday")
        }
    }

    failureConditions {
        errorMessage = true
    }

    dependencies {
        snapshot(Final) {
        }
    }

    requirements {
        matches("teamcity.agent.name", "dev3.*")
        contains("teamcity.agent.jvm.os.name", "Linux")
    }
})
