package ch.fitfusion.backfusion.auth.rbac.utils

import ch.fitfusion.backfusion.auth.rbac.FitFusionToken
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.util.*
import javax.crypto.SecretKey

@Configuration
@ConfigurationProperties(prefix = "jwt")
open class JwtConfiguration {

    var expTime: Int = -1

    var secret: String = ""

    @PostConstruct
    private fun init() {
        config = this
        algorithm = Keys.hmacShaKeyFor(Base64.getDecoder().decode(config.secret))
    }
}

private lateinit var config: JwtConfiguration

private lateinit var algorithm: SecretKey

fun FitFusionToken.buildToken(): String {

    val roles = mapOf(Pair("roles", this.authorities))

    return Jwts.builder()
        .issuer(this.issuer)
        .subject(this.subject)
        .claims(roles)
        .issuedAt(currentTimePlus(0))
        .expiration(currentTimePlus(config.expTime))
        .signWith(algorithm)
        .compact()
}

fun FitFusionToken.buildTokens(): Map<String, String> {

    val authToken = this.buildToken()

    val refreshToken = Jwts.builder()
        .issuer(this.issuer)
        .subject(this.subject)
        .claim("isRefresh", "true")
        .issuedAt(currentTimePlus(0))
        .expiration(currentTimePlus(config.expTime * 2))
        .signWith(algorithm)
        .compact()

    return mapOf(
        Pair("access-token", authToken),
        Pair("refresh-token", refreshToken),
    )
}

fun validateToken(token: String): Boolean {

    val parsedToken = Jwts.parser()
        .verifyWith(algorithm)
        .build()
        .parse(token)

    return parsedToken != null
}

fun decodeToken(token: String): FitFusionToken {

    val decodedToken = Jwts.parser()
        .verifyWith(algorithm)
        .build()
        .parseSignedClaims(token)
        .payload

    val roles = decodedToken["roles"] as List<*>

    return FitFusionToken(
        decodedToken.issuer,
        decodedToken.subject,
        roles.map { it.toString() }.toSet()
    )
}

private fun currentTimePlus(seconds: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.SECOND, seconds)
    return calendar.time
}


