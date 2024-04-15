buildscript {
    val guava_version = providers.gradleProperty("guava.version").get()
    val junit_jupiter_version = providers.gradleProperty("junit-jupiter.version").get()
    val lombok_version = providers.gradleProperty("lombok.version").get()

    extra.apply {
        set("jupiter-api", "org.junit.jupiter:junit-jupiter-api:$junit_jupiter_version")
        set("jupiter-engine", "org.junit.jupiter:junit-jupiter-engine:$junit_jupiter_version")
        set("jupiter-launcher", "org.junit.platform:junit-platform-launcher")
        set("lombok", "org.projectlombok:lombok:$lombok_version")
        set("guava", "com.google.guava:guava:$guava_version")
    }
}
