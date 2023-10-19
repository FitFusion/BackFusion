package ch.fitfusion.backfusion.api.account.services

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.common.dtos.ValidationDTO

interface AccountService {

    fun register(accountIn: AccountInDTO): AccountOutDTO

    fun validateEmail(email: String): ValidationDTO

    fun updateAccount(account: AccountDTO): AccountOutDTO
}
