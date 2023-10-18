package ch.fitfusion.backfusion.auth.rbac

import java.io.Serializable

data class FitFusionToken(
    val issuer: String,
    val subject: String,
    val authorities: Set<String>,
) : Serializable
