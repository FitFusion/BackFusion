package ch.fitfusion.backfusion.rs.api.anonymous

import ch.fitfusion.backfusion.api.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.dtos.OutDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/anonymous/account")
@Tag(name = "Anonymous Account Service")
interface AnonymousAccountResourceService {

    @PostMapping
    @Operation(summary = "Gets a TestDTO from the secured part of the API")
    @ApiResponse(
        responseCode = "200",
        description = "TestDTO",
    )
    fun register(): ResponseEntity<AccountOutDTO>

    @PostMapping("/validate-email")
    @Operation(summary = "Gets a TestDTO from the secured part of the API")
    @ApiResponse(
        responseCode = "200",
        description = "TestDTO",
    )
    fun validateEmail(): ResponseEntity<OutDTO>
}
