package ch.fitfusion.backfusion.app.rbac

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter

class AuthenticationFilter : AbstractAuthenticationProcessingFilter {

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {

    }

}
