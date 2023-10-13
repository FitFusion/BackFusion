package ch.fitfusion.backfusion.app.filters

import io.swagger.v3.oas.models.PathItem.HttpMethod
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken.unauthenticated
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component
import org.springframework.web.HttpRequestMethodNotSupportedException
import java.nio.charset.StandardCharsets.UTF_8
import java.util.Base64

@Component
class JWTAuthenticationFilter : UsernamePasswordAuthenticationFilter() {

    private var postOnly = true

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication {

        if (postOnly && request.method != HttpMethod.POST.name) {
            throw HttpRequestMethodNotSupportedException("Method ${request.method} not supported.")
        }

        val basicAuthorization = getBasicAuthorization(request)

        val authRequest = unauthenticated(basicAuthorization.username, basicAuthorization.password)
        setDetails(request, authRequest)

        return authenticationManager.authenticate(authRequest)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        super.successfulAuthentication(request, response, chain, authResult)
    }

    private fun getBasicAuthorization(request: HttpServletRequest?): BasicAuthorization {

        val header = request?.getHeader("Authorization")?.substring("Basic ".length) ?: ""
        val base64Credentials = Base64.getDecoder().decode(header)
        val credentials = String(base64Credentials, UTF_8).split(":")

        return BasicAuthorization(credentials[0], credentials[1])
    }

    private data class BasicAuthorization(
        val username: String,
        val password: String,
    )
}
