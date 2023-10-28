package ch.fitfusion.backfusion.account.services.validation.types

import ch.fitfusion.backfusion.api.validation.ValidationType
import ch.fitfusion.backfusion.api.validation.ValidationType.ERROR
import ch.fitfusion.backfusion.api.validation.types.ValidationReason

enum class AccountValidationReason(
    private val type: ValidationType
) : ValidationReason {

    EMAIL_INVALID(ERROR);

    override fun getReason() = "$type.${name.lowercase()}"
}
