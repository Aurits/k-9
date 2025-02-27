plugins {
    id(ThunderbirdPlugins.Library.androidCompose)
}

android {
    namespace = "app.k9mail.feature.account.server.settings"
    resourcePrefix = "account_server_settings_"

    buildTypes {
        debug {
            manifestPlaceholders["appAuthRedirectScheme"] = "FIXME: override this in your app project"
        }
        release {
            manifestPlaceholders["appAuthRedirectScheme"] = "FIXME: override this in your app project"
        }
    }
}

dependencies {
    implementation(projects.core.ui.compose.designsystem)
    implementation(projects.core.common)

    implementation(projects.mail.common)
    implementation(projects.mail.protocols.imap)

    implementation(projects.feature.account.common)
    implementation(project(mapOf("path" to ":app:core")))
    implementation(libs.play.services.mlkit.text.recognition.common)

    testImplementation(projects.core.ui.compose.testing)
}
