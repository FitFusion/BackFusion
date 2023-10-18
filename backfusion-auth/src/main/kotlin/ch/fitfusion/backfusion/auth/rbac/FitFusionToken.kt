package ch.fitfusion.backfusion.auth.rbac

data class FitFusionToken(
    val issuer: String,
    val subject: String,
    val authorities: Set<String>,
)
