package ch.fitfusion.backfusion.rs.api.authenticated

import ch.fitfusion.backfusion.api.dtos.TestDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = "Test Services")
interface AuthenticatedTestResourceService {

    @Operation(summary = "Gets a TestDTO from the secured part of the API")
    @ApiResponse(
        responseCode = "200",
        description = "TestDTO",
    )
    fun authTest(): ResponseEntity<TestDTO>
}
