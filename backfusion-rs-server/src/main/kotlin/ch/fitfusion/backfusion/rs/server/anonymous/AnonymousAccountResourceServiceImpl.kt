package ch.fitfusion.backfusion.rs.server.anonymous

import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.common.dtos.ValidationDTO
import ch.fitfusion.backfusion.api.account.services.AccountService
import ch.fitfusion.backfusion.rs.api.anonymous.AnonymousAccountResourceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AnonymousAccountResourceServiceImpl(
    private val accountService: AccountService
) : AnonymousAccountResourceService {

    override fun register(accountIn: AccountInDTO): ResponseEntity<AccountOutDTO> {
        return ResponseEntity.ok(accountService.register(accountIn))
    }

    override fun validateEmail(email: String): ResponseEntity<ValidationDTO> {
        return ResponseEntity.ok(accountService.validateEmail(email))
    }
}
