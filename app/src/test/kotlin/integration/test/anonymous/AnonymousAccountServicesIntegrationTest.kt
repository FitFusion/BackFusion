package integration.test.anonymous

import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import integration.test.ANON_URL
import integration.test.BackFusionApplicationTest
import integration.test.When
import com.google.gson.Gson
import org.junit.jupiter.api.Test

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
