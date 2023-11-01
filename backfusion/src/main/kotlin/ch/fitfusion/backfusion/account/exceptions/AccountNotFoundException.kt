package ch.fitfusion.backfusion.account.exceptions

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.server.ResponseStatusException

class AccountNotFoundException : ResponseStatusException(NOT_FOUND, "Account not found!")
