package ch.fitfusion.backfusion.services

import ch.fitfusion.backfusion.api.dtos.TestDTO
import ch.fitfusion.backfusion.api.services.TestService
import org.springframework.stereotype.Service

@Service
class TestServiceImpl : TestService {

    override fun test() = TestDTO("Hello Anonymous")

    override fun authTest() = TestDTO("Hello Authenticated")
}
