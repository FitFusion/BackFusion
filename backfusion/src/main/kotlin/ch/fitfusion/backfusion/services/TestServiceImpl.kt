package ch.fitfusion.backfusion.services

import ch.fitfusion.backfusion.api.dtos.TestDTO
import ch.fitfusion.backfusion.api.services.TestService

class TestServiceImpl : TestService {

    override fun test() = TestDTO("Hello there")
}
