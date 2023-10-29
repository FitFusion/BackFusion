package ch.fitfusion.backfusion.account.services.validation.types

import ch.fitfusion.backfusion.api.validation.types.ValidationField

private const val typeCode = "error.account"

enum class AccountValidationField(
    private val code: String
) : ValidationField {

    EMAIL("email"),
    USERNAME("username"),
    PASSWORD("password");

    override fun fieldName() = code

    override fun getCode() = "$typeCode.$code"
}
