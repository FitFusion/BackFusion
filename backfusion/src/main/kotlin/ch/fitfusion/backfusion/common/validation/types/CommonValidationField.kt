package ch.fitfusion.backfusion.common.validation.types

import ch.fitfusion.backfusion.api.validation.types.ValidationField

private const val typeCode = "error.common"

enum class CommonValidationField(
    private val code: String
) : ValidationField {

    DTO( "dto"),
    ID( "id"),
    TITLE( "title");

    override fun fieldName() = code

    override fun getCode() = "$typeCode.$code"
}
