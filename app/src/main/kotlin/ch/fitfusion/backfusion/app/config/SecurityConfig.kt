package ch.fitfusion.backfusion.app.config

import ch.fitfusion.backfusion.app.filters.JWTAuthenticationFilter
import ch.fitfusion.backfusion.app.filters.JWTAuthorizationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

val AUTH_WHITELIST = arrayOf(
    "/api-docs",
    "/swagger-resources/",
    "/swagger-ui",
    "/swagger-ui.html",
    "/anonymous/**",
)

val AUTH_WHITELIST_PATTERN = arrayOf(
    "\\/anonymous\\/[\\d\\D]*"
)

@Configuration
@EnableWebSecurity
open class SecurityConfig(
    private val userDetailsService: UserDetailsService,
) {

    @Bean
    open fun configureSecurity(httpSecurity: HttpSecurity): SecurityFilterChain {

        val jwtAuthenticationFilter = JWTAuthenticationFilter()
        jwtAuthenticationFilter.setFilterProcessesUrl("/authenticate")

        httpSecurity
            .csrf { }
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
    open fun configureAuthManager(authManager: AuthenticationManagerBuilder) {
        authManager.userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder())
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
