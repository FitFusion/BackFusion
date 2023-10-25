package ch.fitfusion.backfusion.api.validation.collectors

import ch.fitfusion.backfusion.api.validation.types.ValidationField

interface FieldCollector {
    fun field(field: ValidationField): ResultCollector
}
