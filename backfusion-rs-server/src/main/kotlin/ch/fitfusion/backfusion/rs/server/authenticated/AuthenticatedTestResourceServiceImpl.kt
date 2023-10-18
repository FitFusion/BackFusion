package ch.fitfusion.backfusion.rs.server.authenticated

import ch.fitfusion.backfusion.api.common.services.TestService
import ch.fitfusion.backfusion.rs.api.authenticated.AuthenticatedTestResourceService
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authenticated/test")
class AuthenticatedTestResourceServiceImpl(
    private val testService: TestService,
) : AuthenticatedTestResourceService {

    @GetMapping
    override fun authTest() = ResponseEntity(testService.authTest(), OK)
}
