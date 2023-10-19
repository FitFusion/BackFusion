package ch.fitfusion.backfusion.auth.rbac.annotations

import ch.fitfusion.backfusion.auth.rbac.Roles
import org.springframework.security.access.annotation.Secured

@Secured(Roles.ADMIN)
annotation class AccessibleByAdmin
