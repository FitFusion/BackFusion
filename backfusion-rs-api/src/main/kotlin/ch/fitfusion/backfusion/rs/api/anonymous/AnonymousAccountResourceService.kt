package ch.fitfusion.backfusion.rs.api.anonymous

import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.common.dtos.ValidationDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/anonymous/account")
@Tag(name = "Anonymous Account Service")
interface AnonymousAccountResourceService {

    @PostMapping
    @Operation(summary = "Gets a TestDTO from the secured part of the API")
    @ApiResponse(
        responseCode = "200",
        description = "TestDTO",
    )
    fun register(@RequestBody accountIn: AccountInDTO): ResponseEntity<AccountOutDTO>

    @PostMapping("/validate-email")
    @Operation(summary = "Gets a TestDTO from the secured part of the API")
    @ApiResponse(
        responseCode = "200",
        description = "TestDTO",
    )
    fun validateEmail(@RequestParam("email") email: String): ResponseEntity<ValidationDTO>
}
