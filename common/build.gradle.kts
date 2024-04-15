dependencies {
    val extension = rootProject.extra

    api(extension.get("guava") as String)
}

tasks.jar { enabled = true }

