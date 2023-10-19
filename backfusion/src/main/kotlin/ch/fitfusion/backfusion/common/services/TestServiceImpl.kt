package ch.fitfusion.backfusion.common.services

import ch.fitfusion.backfusion.api.test.dtos.TestDTO
import ch.fitfusion.backfusion.api.common.services.TestService
import org.springframework.stereotype.Service

@Service
class TestServiceImpl : TestService {

    override fun test() = TestDTO("Hello Anonymous")

    override fun authTest() = TestDTO("Hello Authenticated")
}
