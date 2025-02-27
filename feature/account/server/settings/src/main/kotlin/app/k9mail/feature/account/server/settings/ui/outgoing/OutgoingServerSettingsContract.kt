package app.k9mail.feature.account.server.settings.ui.outgoing

import app.k9mail.core.common.domain.usecase.validation.ValidationResult
import app.k9mail.core.ui.compose.common.mvi.UnidirectionalViewModel
import app.k9mail.feature.account.common.domain.entity.AuthenticationType
import app.k9mail.feature.account.common.domain.entity.ConnectionSecurity
import app.k9mail.feature.account.common.domain.input.NumberInputField
import app.k9mail.feature.account.common.domain.input.StringInputField
import com.fsck.k9.AppConfig

interface OutgoingServerSettingsContract {

    interface ViewModel : UnidirectionalViewModel<State, Event, Effect>

    data class State(
        val server: StringInputField = StringInputField("webmail.mak.ac.ug"),
        val security: ConnectionSecurity = ConnectionSecurity.StartTLS,
        val port: NumberInputField = NumberInputField(587),
        val authenticationType: AuthenticationType = AuthenticationType.PasswordCleartext,
        val username: StringInputField = StringInputField(),
        val password: StringInputField = StringInputField(AppConfig.password),
        val clientCertificateAlias: String? = null,
    )

    sealed interface Event {
        data class ServerChanged(val server: String) : Event
        data class SecurityChanged(val security: ConnectionSecurity) : Event
        data class PortChanged(val port: Long?) : Event
        data class AuthenticationTypeChanged(val authenticationType: AuthenticationType) : Event
        data class UsernameChanged(val username: String) : Event
        data class PasswordChanged(val password: String) : Event
        data class ClientCertificateChanged(val clientCertificateAlias: String?) : Event

        object LoadAccountState : Event

        object OnNextClicked : Event
        object OnBackClicked : Event
    }

    sealed interface Effect {
        object NavigateNext : Effect
        object NavigateBack : Effect
    }

    interface Validator {
        fun validateServer(server: String): ValidationResult
        fun validatePort(port: Long?): ValidationResult
        fun validateUsername(username: String): ValidationResult
        fun validatePassword(password: String): ValidationResult
    }
}
