package integration.test

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.annotation.AliasFor
import org.springframework.test.context.ActiveProfiles
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.TYPE

@Retention(RUNTIME)
@Target(TYPE, CLASS)
@SpringBootTest
@ActiveProfiles
annotation class BackFusionApplicationTest(
    @get:AliasFor(annotation = ActiveProfiles::class, attribute = "profiles")
    val activeProfiles: Array<String> = ["dev"]
)
