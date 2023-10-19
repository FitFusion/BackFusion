package ch.fitfusion.backfusion.auth.rbac

import org.springframework.security.core.GrantedAuthority
import java.io.Serializable

data class FitFusionToken(
    var issuer: String,
    var subject: String,
    var authorities: Set<String>,
) : Serializable {

    fun getGrantedAuthorities(): List<GrantedAuthority> {
        return authorities.map { GrantedAuthority { it } }.toList()
    }

    fun setGrantedAuthorities(grantedAuthorities: List<GrantedAuthority>) {
        this.authorities = grantedAuthorities.map { it.authority }.toSet()
    }
}
