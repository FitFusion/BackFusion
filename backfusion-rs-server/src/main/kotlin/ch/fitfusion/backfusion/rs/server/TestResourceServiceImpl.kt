package ch.fitfusion.backfusion.rs.server

import ch.fitfusion.backfusion.api.services.TestService
import ch.fitfusion.backfusion.rs.api.TestResourceService
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestResourceServiceImpl(
    private val testService: TestService,
) : TestResourceService {

    @GetMapping
    override fun test() = ResponseEntity(testService.test(), OK)
}
