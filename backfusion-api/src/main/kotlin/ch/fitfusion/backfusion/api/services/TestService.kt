package ch.fitfusion.backfusion.api.services

import ch.fitfusion.backfusion.api.dtos.TestDTO

interface TestService {

    fun test(): TestDTO
}
