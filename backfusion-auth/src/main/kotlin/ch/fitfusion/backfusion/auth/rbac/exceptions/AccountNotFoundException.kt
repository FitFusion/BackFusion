package ch.fitfusion.backfusion.auth.rbac.exceptions

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.server.ResponseStatusException

class AccountNotFoundException : ResponseStatusException(NOT_FOUND, "Account not found!")
