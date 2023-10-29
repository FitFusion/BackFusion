package ch.fitfusion.backfusion.api.validation.types

interface ValidationField {

    fun fieldName(): String

    fun getCode(): String
}
