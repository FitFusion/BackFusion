package ch.fitfusion.backfusion.account.services.validation.types

import ch.fitfusion.backfusion.api.validation.types.ValidationField

enum class AccountValidationField : ValidationField {
    EMAIL,
    USERNAME,
    PASSWORD;
}
