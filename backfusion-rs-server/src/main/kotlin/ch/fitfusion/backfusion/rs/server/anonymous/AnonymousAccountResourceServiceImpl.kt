package ch.fitfusion.backfusion.rs.server.anonymous

import ch.fitfusion.backfusion.api.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.dtos.OutDTO
import ch.fitfusion.backfusion.api.services.AccountService
import ch.fitfusion.backfusion.rs.api.anonymous.AnonymousAccountResourceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AnonymousAccountResourceServiceImpl(
    private val accountService: AccountService
) : AnonymousAccountResourceService {

    override fun register(): ResponseEntity<AccountOutDTO> {
        return ResponseEntity.ok(accountService.register())
    }

    override fun validateEmail(): ResponseEntity<OutDTO> {
        return ResponseEntity.ok(accountService.validateEmail())
    }
}
