package ch.fitfusion.backfusion.auth.rbac.filters

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpMethod.POST
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken.unauthenticated
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.nio.charset.StandardCharsets.UTF_8
import java.util.*

class JWTAuthenticationFilter(
    authenticationManager: AuthenticationManager
) : UsernamePasswordAuthenticationFilter(authenticationManager) {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication {

        request.assertMethod(POST)

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
