package ch.fitfusion.backfusion.app.filters

import ch.fitfusion.backfusion.app.config.AUTH_WHITELIST_PATTERN
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.core.annotation.Order
import org.springframework.security.access.AccessDeniedException
import org.springframework.web.filter.OncePerRequestFilter
import java.util.regex.Pattern

@Order(20)
class JWTAuthorizationFilter : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        val authToken = request.getHeader("Authorization")

        if (authToken != null) {
            logger.info("Auth token: $authToken")
            chain.doFilter(request, response)
            return
        }

        logger.debug("Creds invalid")
        throw AccessDeniedException("Creds invalid!")
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        logger.info("Filter for req ${request.requestURI} skipped")
        return AUTH_WHITELIST_PATTERN.any { Pattern.matches(it, request.requestURI) }
    }
}
