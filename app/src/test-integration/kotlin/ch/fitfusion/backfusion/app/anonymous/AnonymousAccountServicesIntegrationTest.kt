package ch.fitfusion.backfusion.app.anonymous

import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.app.ANON_URL
import ch.fitfusion.backfusion.app.BackFusionApplicationTest
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

private const val ANON_ACCOUNT_URL = "$ANON_URL/account"

@BackFusionApplicationTest
class AnonymousAccountServicesIntegrationTest {

    @Test
    fun `Test registration with valid input data`() {

//        with
//            .body(Gson().toJson(createValidInput()))
//        .When()
//            .post(ANON_ACCOUNT_URL)
//        .then()
//            .statusCode(200)
        assertFalse { true }
        println("SANANAS")
    }

    @Test
    fun `Test registration with invalid input data`() {
        println("SANANAS")
    }

    @Test
    fun validateEmail() {
        println("SANANAS")
    }

    private fun createValidInput(): AccountInDTO {
        return AccountInDTO(
            null,
            "username",
            "mail@fitfusion.ch",
            "password",
        )
    }
}
