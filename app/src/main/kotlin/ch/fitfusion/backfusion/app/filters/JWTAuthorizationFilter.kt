package ch.fitfusion.backfusion.app.filters

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.access.AccessDeniedException
import org.springframework.web.filter.OncePerRequestFilter

class JWTAuthorizationFilter : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        val authToken = request.getHeader("Authorization")

        if (authToken != null) {
            logger.info("Auth token: $authToken")
            chain.doFilter(request, response)
            return
        }

        logger.debug("Creds invalid")
        throw AccessDeniedException("Credentials invalid!")
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        return skipAnonymousUrl(request, this::class)
    }
}
