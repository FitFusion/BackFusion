package ch.fitfusion.backfusion.rs.api.anonymous

import ch.fitfusion.backfusion.api.test.dtos.TestDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = "Test Services")
interface AnonymousTestResourceService {

    @Operation(summary = "Get a TestDTO from the API!")
    @ApiResponse(
        responseCode = "200",
        description = "TestDTO",
    )
    @ApiResponse()
    fun test(): ResponseEntity<TestDTO>
}
