package ch.fitfusion.backfusion.app.config

import ch.fitfusion.backfusion.auth.rbac.AUTH_WHITELIST
import ch.fitfusion.backfusion.auth.rbac.filters.JWTAuthenticationFilter
import ch.fitfusion.backfusion.auth.rbac.filters.JWTAuthorizationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
@EnableWebSecurity
open class SecurityConfig(
    private val authenticationConfiguration: AuthenticationConfiguration,
) {

    @Bean
    open fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {

        val jwtAuthenticationFilter = JWTAuthenticationFilter(authenticationManager())
        jwtAuthenticationFilter.setFilterProcessesUrl("/authenticate")

        httpSecurity
            .csrf { it.disable() }
            .httpBasic { it.disable() }
            .formLogin { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers(*AUTH_WHITELIST).permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter::class.java)
            .addFilterAfter(JWTAuthorizationFilter(), JWTAuthenticationFilter::class.java)

        return httpSecurity.build()
    }

    @Bean
    open fun authenticationManager(): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    open fun bCryptPasswordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
