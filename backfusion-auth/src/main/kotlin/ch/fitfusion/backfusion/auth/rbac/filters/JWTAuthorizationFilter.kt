package ch.fitfusion.backfusion.auth.rbac.filters

import ch.fitfusion.backfusion.auth.rbac.exceptions.InvalidAuthHeaderException
import ch.fitfusion.backfusion.auth.rbac.exceptions.InvalidTokenException
import ch.fitfusion.backfusion.auth.rbac.utils.decodeToken
import ch.fitfusion.backfusion.auth.rbac.utils.validateToken
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders.AUTHORIZATION
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.filter.OncePerRequestFilter

private const val bearerPrefix = "Bearer "

class JWTAuthorizationFilter(
    private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        var accessToken = request.getHeader(AUTHORIZATION)

        if (accessToken == null || !accessToken.startsWith(bearerPrefix)) {
            throw InvalidAuthHeaderException()
        }

        accessToken = accessToken.removePrefix(bearerPrefix)

        val tokenValid = validateToken(accessToken)

        if (!tokenValid) {
            throw InvalidTokenException()
        }

        val decodeToken = decodeToken(accessToken)

        val userDetails = userDetailsService.loadUserByUsername(decodeToken.subject)

        val authenticationToken =
            UsernamePasswordAuthenticationToken(userDetails, null, decodeToken.getGrantedAuthorities())

        SecurityContextHolder.getContext().authentication = authenticationToken

        chain.doFilter(request, response)
    }

    override fun shouldNotFilter(request: HttpServletRequest) = skipAnonymousUrl(request, this::class)
}
