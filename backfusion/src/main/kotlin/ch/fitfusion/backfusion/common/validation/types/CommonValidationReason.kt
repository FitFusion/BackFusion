package ch.fitfusion.backfusion.common.validation.types

import ch.fitfusion.backfusion.api.validation.ValidationType
import ch.fitfusion.backfusion.api.validation.ValidationType.ERROR
import ch.fitfusion.backfusion.api.validation.types.ValidationReason

enum class CommonValidationReason(
    private val type: ValidationType
) : ValidationReason {

    MANDATORY(ERROR),
    VALUE_TOO_LONG(ERROR);

    override fun getReason() = "$type.${name.lowercase()}"
}
