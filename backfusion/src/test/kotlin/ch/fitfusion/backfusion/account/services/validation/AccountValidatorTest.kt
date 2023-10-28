package ch.fitfusion.backfusion.account.services.validation

import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AccountValidatorTest {

    private val validator = AccountValidator()

    @Test
    fun `Test validator working correctly with valid DTO`() {
        val result = validator.validate(createValidAccount())

        assertEquals(0, result.errors.size)
    }

    @Test
    fun `Test validator working correctly with invalid DTO`() {
        val result = validator.validate(createInvalidAccount())

        assertEquals(3, result.errors.size)
    }

    private fun createValidAccount(): AccountInDTO {
        return AccountInDTO(
            "username",
            "info@fitfusion.ch",
            "Wow, such a secure password",
        )
    }

    private fun createInvalidAccount(): AccountInDTO {
        return AccountInDTO(
            null,
            null,
            null,
        )
    }
}
