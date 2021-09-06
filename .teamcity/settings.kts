import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.1"

project {
    description = "Contains all other projects"

    vcsRoot(HttpsGithubComIgorkeksKotlinGit)

    cleanup {
        baseRule {
            preventDependencyCleanup = false
        }
    }

    subProject(Kotlin)
}

object HttpsGithubComIgorkeksKotlinGit : GitVcsRoot({
    name = "https://github.com/Igorkeks/kotlin.git"
    url = "https://github.com/Igorkeks/kotlin.git"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "igorkeks"
        password = "credentialsJSON:7b3b6f05-e143-4605-b138-1a6a47d47fb4"
    }
})


object Kotlin : Project({
    name = "kotlin"
})
