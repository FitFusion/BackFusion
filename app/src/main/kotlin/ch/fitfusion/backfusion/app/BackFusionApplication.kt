package ch.fitfusion.backfusion.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
open class BackFusionApplication

fun main(args: Array<String>) {

    runApplication<BackFusionApplication>(*args)
}
