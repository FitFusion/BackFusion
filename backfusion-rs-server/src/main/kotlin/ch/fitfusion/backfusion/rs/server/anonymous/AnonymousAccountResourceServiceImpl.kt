package ch.fitfusion.backfusion.rs.server.anonymous

import ch.fitfusion.backfusion.api.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.dtos.ValidationDTO
import ch.fitfusion.backfusion.api.services.AccountService
import ch.fitfusion.backfusion.rs.api.anonymous.AnonymousAccountResourceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AnonymousAccountResourceServiceImpl(
    private val accountService: AccountService
) : AnonymousAccountResourceService {

    override fun register(): ResponseEntity<AccountOutDTO> {
        val register = accountService.register()
        return ResponseEntity.ok(register)
    }

    override fun validateEmail(): ResponseEntity<ValidationDTO> {
        return ResponseEntity.ok(accountService.validateEmail())
    }
}
