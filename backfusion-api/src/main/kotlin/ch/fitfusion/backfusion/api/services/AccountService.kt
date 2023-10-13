package ch.fitfusion.backfusion.api.services

import ch.fitfusion.backfusion.api.dtos.AccountDTO
import ch.fitfusion.backfusion.api.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.dtos.ValidationDTO

interface AccountService {

    fun register(): AccountOutDTO

    fun validateEmail(): ValidationDTO

    fun updateAccount(account: AccountDTO): AccountOutDTO
}
