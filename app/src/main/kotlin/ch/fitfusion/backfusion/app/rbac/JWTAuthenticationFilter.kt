package ch.fitfusion.backfusion.app.rbac

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.core.Ordered
import org.springframework.security.access.AccessDeniedException
import org.springframework.web.filter.OncePerRequestFilter

class JWTAuthenticationFilter : OncePerRequestFilter(), Ordered {

    override fun getOrder() = 10

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        val username = request.getHeader("username")
        val password = request.getHeader("password")

        if (checkCreds(username, password)) {
            chain.doFilter(request, response)
            logger.debug("Filter passed. User authenticated")
            return
        }

        logger.debug("Creds invalid")
        throw AccessDeniedException("Creds invalid!")
    }

    private fun checkCreds(u: String, p: String): Boolean {
        return u == "admin" && p == "admin"
    }
}
