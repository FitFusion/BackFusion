package ch.fitfusion.backfusion.api.common.services

import ch.fitfusion.backfusion.api.test.dtos.TestDTO

interface TestService {

    fun test(): TestDTO

    fun authTest(): TestDTO
}
