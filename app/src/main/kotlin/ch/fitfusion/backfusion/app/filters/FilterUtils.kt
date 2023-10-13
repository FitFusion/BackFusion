package ch.fitfusion.backfusion.app.filters

import ch.fitfusion.backfusion.app.config.AUTH_WHITELIST_PATTERN
import jakarta.servlet.http.HttpServletRequest
import java.util.regex.Pattern
import kotlin.reflect.KClass

fun <T : Any> skipAnonymousUrl(request: HttpServletRequest, caller: KClass<T>): Boolean {

    val shouldSkip = AUTH_WHITELIST_PATTERN.any { Pattern.matches(it, request.requestURI) }

    if (shouldSkip) print("Skip ${caller.simpleName} for ${request.requestURI}")

    return shouldSkip
}

