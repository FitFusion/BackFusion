package ch.fitfusion.backfusion.auth.rbac.exceptions

import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.web.server.ResponseStatusException

class InvalidAuthHeaderException : ResponseStatusException(UNAUTHORIZED, "Invalid Authentication Header provided")
