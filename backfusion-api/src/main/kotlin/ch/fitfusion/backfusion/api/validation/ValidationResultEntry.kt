package ch.fitfusion.backfusion.api.validation

import ch.fitfusion.backfusion.api.validation.ValidationType.*
import ch.fitfusion.backfusion.api.validation.types.ValidationField
import ch.fitfusion.backfusion.api.validation.types.ValidationReason

class ValidationResultEntry(
    val type: ValidationType,
    val field: ValidationField,
    val reason: ValidationReason,
) {
    companion object {
        fun error(field: ValidationField, reason: ValidationReason) = ValidationResultEntry(ERROR, field, reason)
        fun warning(field: ValidationField, reason: ValidationReason) = ValidationResultEntry(WARNING, field, reason)
        fun info(field: ValidationField, reason: ValidationReason) = ValidationResultEntry(INFO, field, reason)
    }
}

enum class ValidationType {
    ERROR,
    WARNING,
    INFO;
}
