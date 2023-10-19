package ch.fitfusion.backfusion.auth.rbac.filters

import ch.fitfusion.backfusion.auth.rbac.AUTH_WHITELIST_PATTERN
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpMethod
import org.springframework.web.HttpRequestMethodNotSupportedException
import java.util.regex.Pattern
import kotlin.reflect.KClass

fun <T : Any> skipAnonymousUrl(request: HttpServletRequest, caller: KClass<T>): Boolean {

    val shouldSkip = AUTH_WHITELIST_PATTERN.any { Pattern.matches(it, request.requestURI) }

    if (shouldSkip) print("Skip ${caller.simpleName} for ${request.requestURI}")

    return shouldSkip
}

fun HttpServletRequest.assertMethod(method: HttpMethod) {
    if (this.method != method.name()) {
        throw HttpRequestMethodNotSupportedException(this.method)
    }
}
