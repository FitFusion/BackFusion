package ch.fitfusion.backfusion.rs.server.anonymous

import ch.fitfusion.backfusion.api.services.TestService
import ch.fitfusion.backfusion.rs.api.anonymous.AnonymousTestResourceService
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/anonymous/test")
class AnonymousTestResourceServiceImpl(
    private val testService: TestService,
) : AnonymousTestResourceService {

    @GetMapping
    override fun test() = ResponseEntity(testService.test(), OK)
}
