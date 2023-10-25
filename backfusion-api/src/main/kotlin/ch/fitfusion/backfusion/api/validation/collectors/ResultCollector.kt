package ch.fitfusion.backfusion.api.validation.collectors

import ch.fitfusion.backfusion.api.validation.ValidationResult

interface ResultCollector : FieldCollector, ReasonCollector {
    fun finish(result: ValidationResult)
}
