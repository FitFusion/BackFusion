package ch.fitfusion.backfusion.rs.api.authenticated

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountOutDTO
import ch.fitfusion.backfusion.auth.rbac.annotations.AccessibleByAdmin
import ch.fitfusion.backfusion.auth.rbac.annotations.AccessibleByUser
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/authenticated/account")
@Tag(name = "Anonymous Account Service")
interface AccountResourceService {

    @PutMapping
    @AccessibleByUser
    fun updateAccount(@RequestBody account: AccountDTO): ResponseEntity<AccountOutDTO>

    @GetMapping("/{id}")
    @AccessibleByAdmin
    fun getAccount(@PathVariable id: Long): ResponseEntity<AccountDTO>

    @GetMapping
    @AccessibleByUser
    fun getAccount(): ResponseEntity<AccountDTO>
}
