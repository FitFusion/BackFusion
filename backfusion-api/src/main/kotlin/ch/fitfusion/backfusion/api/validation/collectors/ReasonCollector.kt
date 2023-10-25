package ch.fitfusion.backfusion.api.validation.collectors

import ch.fitfusion.backfusion.api.validation.types.ValidationReason

interface ReasonCollector {
    fun reason(reason: ValidationReason): ResultCollector
}
