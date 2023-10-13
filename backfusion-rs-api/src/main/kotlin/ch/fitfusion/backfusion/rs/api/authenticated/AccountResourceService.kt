package ch.fitfusion.backfusion.rs.api.authenticated

import ch.fitfusion.backfusion.api.dtos.AccountDTO
import ch.fitfusion.backfusion.api.dtos.AccountOutDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/authenticated/account")
@Tag(name = "Anonymous Account Service")
interface AccountResourceService {

    @PutMapping
    @Operation(summary = "Gets a TestDTO from the secured part of the API")
    @ApiResponse(
        responseCode = "200",
        description = "TestDTO",
    )
    fun updateAccount(@RequestBody account: AccountDTO): ResponseEntity<AccountOutDTO>
}
