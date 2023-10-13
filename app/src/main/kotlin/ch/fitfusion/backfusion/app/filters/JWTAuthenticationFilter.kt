package ch.fitfusion.backfusion.app.filters

import io.swagger.v3.oas.models.PathItem.HttpMethod
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken.unauthenticated
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.HttpRequestMethodNotSupportedException

class JWTAuthenticationFilter : UsernamePasswordAuthenticationFilter() {

    private var postOnly = true

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication {

        if (postOnly && request.method != HttpMethod.POST.name) {
            throw HttpRequestMethodNotSupportedException("Method ${request.method} not supported.")
        }

        val username = obtainUsername(request)?.trim { it <= ' ' } ?: ""
        val password = obtainPassword(request) ?: ""

        val authRequest = unauthenticated(username, password)
        setDetails(request, authRequest)

        return authenticationManager.authenticate(authRequest)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {

    }

    override fun unsuccessfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        failed: AuthenticationException?
    ) {
        super.unsuccessfulAuthentication(request, response, failed)
    }
}
