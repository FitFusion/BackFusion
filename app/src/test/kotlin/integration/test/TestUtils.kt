package integration.test

import io.restassured.specification.RequestSpecification

const val BASE_URL = "http://localhost:8080"
const val ANON_URL = "$BASE_URL/anonymous"
const val AUTH_URL = "$BASE_URL/authenticated"

fun RequestSpecification.When(): RequestSpecification = this.`when`()
