plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "multimodule-gradle-kts"

include("app-2")
include("app-1")
include("common")
