package ch.fitfusion.backfusion.app.config

import ch.fitfusion.backfusion.app.rbac.JWTAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.access.intercept.AuthorizationFilter


@Configuration
@EnableWebSecurity
open class SecurityConfig {

    private val AUTH_WHITELIST = arrayOf(
        "/api-docs",
        "/swagger-resources/",
        "/swagger-ui",
        "/swagger-ui.html",
        "/anonymous/**",
    )

    @Bean
    open fun configure(httpSecurity: HttpSecurity): SecurityFilterChain {

        httpSecurity
            .csrf { }
            .httpBasic { it.disable() }
            .formLogin { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers(*AUTH_WHITELIST).permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterAfter(JWTAuthenticationFilter(), AuthorizationFilter  ::class.java)

        return httpSecurity.build()
    }

    @Bean
    open fun bCryptPasswordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    open fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }
}
