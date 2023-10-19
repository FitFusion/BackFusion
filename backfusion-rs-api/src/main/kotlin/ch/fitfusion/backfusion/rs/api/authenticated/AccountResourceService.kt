package ch.fitfusion.backfusion.rs.api.authenticated

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountOutDTO
import ch.fitfusion.backfusion.auth.rbac.annotations.AccessibleByUser
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/authenticated/account")
@Tag(name = "Anonymous Account Service")
interface AccountResourceService {

    @PutMapping
    @AccessibleByUser
    fun updateAccount(@RequestBody account: AccountDTO): ResponseEntity<AccountOutDTO>
}
