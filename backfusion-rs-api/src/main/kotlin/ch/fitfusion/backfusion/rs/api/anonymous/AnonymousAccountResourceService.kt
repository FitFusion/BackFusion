package ch.fitfusion.backfusion.rs.api.anonymous

import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.common.dtos.ValidationDTO
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
    fun register(@RequestBody accountIn: AccountInDTO): ResponseEntity<AccountOutDTO>

    @PostMapping("/validate-email")
    fun validateEmail(@RequestParam("email") email: String): ResponseEntity<ValidationDTO>
}
