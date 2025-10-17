plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt") // ⬅ sua main
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.websockets)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.sessions)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
    //implementation("org.mongodb:mongodb-driver-kotlin-sync:5.2.1") // ou versão mais recente
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    //implementation("org.litote.kmongo:kmongo-coroutine-serialization:<latest-version>")

    implementation("org.litote.kmongo:kmongo:4.11.0")
    implementation("org.litote.kmongo:kmongo-coroutine:4.11.0")
    implementation("org.litote.kmongo:kmongo-serialization:4.11.0")
    implementation("org.litote.kmongo:kmongo-coroutine-serialization:4.11.0")

    implementation("io.insert-koin:koin-core:3.5.3")
    implementation("io.insert-koin:koin-ktor:3.5.3")
    implementation("io.insert-koin:koin-logger-slf4j:3.5.3")
}
