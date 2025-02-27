plugins {
    id(ThunderbirdPlugins.Library.androidCompose)
}

android {
    namespace = "app.k9mail.feature.account.setup"
    resourcePrefix = "account_setup_"

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
    implementation(projects.mail.protocols.pop3)
    implementation(projects.mail.protocols.smtp)

    implementation(projects.feature.autodiscovery.service)

    api(projects.feature.account.common)
    implementation(projects.feature.account.oauth)
    implementation(projects.feature.account.server.settings)
    implementation(projects.feature.account.server.certificate)
    api(projects.feature.account.server.validation)
    implementation(project(mapOf("path" to ":feature:autodiscovery:autoconfig")))
    implementation(project(mapOf("path" to ":app:core")))
    implementation(project(mapOf("path" to ":app:core")))

    testImplementation(projects.core.ui.compose.testing)
}
