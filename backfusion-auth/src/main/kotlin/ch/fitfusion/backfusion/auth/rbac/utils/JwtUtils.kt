package ch.fitfusion.backfusion.auth.rbac.utils

import ch.fitfusion.backfusion.auth.rbac.FitFusionToken
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
@ConfigurationProperties(prefix = "jwt")
open class JwtConfiguration {

    var expTime: Int = -1

    var secret: String = ""

    @PostConstruct
    private fun init() {
        config = this
    }
}

private lateinit var config: JwtConfiguration

fun FitFusionToken.buildToken(): String {

    val roles = mapOf(Pair("roles", this.authorities))
    val expDate = currentTimePlus(config.expTime)

    val algorithm = Keys.hmacShaKeyFor(Base64.getDecoder().decode(config.secret))

    return Jwts.builder()
        .issuer(this.issuer)
        .subject(this.subject)
        .claims(roles)
        .issuedAt(currentTimePlus(0))
        .expiration(expDate)
        .signWith(algorithm)
        .compact()
}

private fun currentTimePlus(seconds: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.SECOND, seconds)
    return calendar.time
}


