package ch.fitfusion.backfusion.api.validation

import ch.fitfusion.backfusion.api.validation.ValidationResultEntry.Companion.error
import ch.fitfusion.backfusion.api.validation.collectors.ResultCollector
import ch.fitfusion.backfusion.api.validation.types.ValidationField
import ch.fitfusion.backfusion.api.validation.types.ValidationReason

class Pass : ResultCollector {

    var isAccept = false

    private lateinit var field: ValidationField
    private lateinit var reason: ValidationReason

    override fun field(field: ValidationField): ResultCollector {
        this.field = field
        return this
    }

    override fun reason(reason: ValidationReason): ResultCollector {
        this.reason = reason
        return this
    }

    override fun finish(result: ValidationResult) {
        if (!isAccept) {
            result.addError(error(field, reason))
        }
    }
}
