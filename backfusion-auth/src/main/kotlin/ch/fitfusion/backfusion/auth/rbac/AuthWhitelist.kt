package ch.fitfusion.backfusion.auth.rbac

val AUTH_WHITELIST = arrayOf(
    "/api-docs",
    "/api-docs/**",
    "/swagger-resources/",
    "/swagger-ui",
    "/swagger-ui.html",
    "/anonymous/**",
    "/h2-console",
    "/h2-console/**",
    "/favicon.ico"
)

val AUTH_WHITELIST_PATTERN = arrayOf(
    "\\/anonymous\\/[\\d\\D]*",
    "\\/h2-console[\\d\\D]*",
)
