package ch.fitfusion.backfusion.auth.rbac.exceptions

import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.web.server.ResponseStatusException

class InvalidTokenException : ResponseStatusException(UNAUTHORIZED, "Invalid Authentication Header provided")
