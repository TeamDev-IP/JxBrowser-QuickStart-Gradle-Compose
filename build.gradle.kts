/*
 *  Copyright 2025, TeamDev. All rights reserved.
 *
 *  Redistribution and use in source and/or binary forms, with or without
 *  modification, must retain the above copyright notice and the following
 *  disclaimer.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 *  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 *  OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

plugins {
    java
    application
    kotlin("jvm") version "2.0.0"
    
    // Provides convenience methods for adding JxBrowser dependencies into a project.
    id("com.teamdev.jxbrowser") version "1.2.1"

    // Adds the Compose plugins for easy configuration.
    id("org.jetbrains.compose") version "1.7.3"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

repositories {
    google()
    mavenCentral()
}

jxbrowser {
    version = "8.9.4"
}

application {
    mainClass.set("com.teamdev.jxbrowser.quickstart.gradle.compose.AppKt")
}

dependencies {
    // Detects the current platform and adds the corresponding Chromium binaries.
    implementation(jxbrowser.currentPlatform)

    // Adds dependency to the Compose Desktop UI toolkit integration.
    implementation(jxbrowser.compose)

    // Adds dependency to the Compose Desktop UI toolkit for the current platform.
    implementation(compose.desktop.currentOs)
}

tasks.withType<JavaExec> {
    // Assign all Java system properties from
    // the command line to the JavaExec task.
    systemProperties(System.getProperties().mapKeys { it.key as String })
}
