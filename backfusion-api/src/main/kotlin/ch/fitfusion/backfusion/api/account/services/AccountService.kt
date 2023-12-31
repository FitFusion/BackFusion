package ch.fitfusion.backfusion.api.account.services

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.common.dtos.ValidationDTO

interface AccountService {

    fun register(accountIn: AccountInDTO): AccountOutDTO

    fun getAccount(id: Long): AccountDTO?

    fun getAccount(): AccountDTO

    fun validateEmail(email: String): ValidationDTO

    fun updateAccount(accountIn: AccountInDTO): AccountOutDTO
}
