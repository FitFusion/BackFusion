package ch.fitfusion.backfusion.services

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TestServiceImplTest {

    private val service = TestServiceImpl()

    @Test
    fun `Method test should output Hello there`() = assertEquals("Hello there", service.test().value)
}
