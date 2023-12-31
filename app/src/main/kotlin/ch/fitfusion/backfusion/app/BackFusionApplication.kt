package ch.fitfusion.backfusion.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@ComponentScan(
    "ch.fitfusion.backfusion",
)
@EntityScan(
    "ch.fitfusion.backfusion",
)
@EnableJpaRepositories(
    "ch.fitfusion.backfusion"
)
@EnableConfigurationProperties
@SpringBootApplication(
    exclude = [
        SecurityAutoConfiguration::class,
    ]
)
open class BackFusionApplication

fun main(args: Array<String>) {

    runApplication<BackFusionApplication>(*args)
}
