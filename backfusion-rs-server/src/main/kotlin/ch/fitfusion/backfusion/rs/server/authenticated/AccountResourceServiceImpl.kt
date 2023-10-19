package ch.fitfusion.backfusion.rs.server.authenticated

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.account.services.AccountService
import ch.fitfusion.backfusion.rs.api.authenticated.AccountResourceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
open class AccountResourceServiceImpl(
    private val accountService: AccountService
) : AccountResourceService {

    override fun updateAccount(account: AccountDTO): ResponseEntity<AccountOutDTO> {
        return ResponseEntity.ok(accountService.updateAccount(account))
    }
}
