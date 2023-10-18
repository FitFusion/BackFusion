package ch.fitfusion.backfusion.auth.rbac.filters

import ch.fitfusion.backfusion.auth.rbac.FitFusionToken
import ch.fitfusion.backfusion.auth.rbac.utils.buildTokens
import com.google.gson.Gson
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpMethod.POST
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken.unauthenticated
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.BufferedOutputStream
import java.io.ObjectOutputStream
import java.nio.charset.StandardCharsets.UTF_8
import java.util.*
import java.util.stream.Collectors

class JWTAuthenticationFilter(
    authenticationManager: AuthenticationManager,
) : UsernamePasswordAuthenticationFilter(authenticationManager) {

    private val gson = Gson()

    override fun attemptAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
    ): Authentication {

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
        authResult: Authentication?,
    ) {

        val principal = authResult!!.principal as UserDetails

        val tokens = FitFusionToken(
            request!!.requestURI,
            principal.username,
            principal.authorities.mapAuthorities()
        ).buildTokens()

        response!!.outputStream.use {
            ObjectOutputStream(BufferedOutputStream(it)).use { oos ->
                oos.writeObject(gson.toJson(tokens))
                oos.flush()
            }
        }
    }

    private fun getBasicAuthorization(
        request: HttpServletRequest?,
    ): BasicAuthorization {

        val header = request?.getHeader("Authorization")?.substring("Basic ".length) ?: ""
        val base64Credentials = Base64.getDecoder().decode(header)
        val credentials = String(base64Credentials, UTF_8).split(":")

        return BasicAuthorization(credentials[0], credentials[1])
    }

    private data class BasicAuthorization(
        val username: String,
        val password: String,
    )

    private fun Collection<GrantedAuthority>.mapAuthorities(): Set<String> {
        return this.stream()
            .map { it.authority }
            .collect(Collectors.toSet())
    }
}
