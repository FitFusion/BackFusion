package ch.fitfusion.backfusion.app

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.assertTrue

@ActiveProfiles("dev")
@SpringBootTest
class BackFusionApplicationTests {

    @Test
    fun contextLoads() = assertTrue { true }
}
