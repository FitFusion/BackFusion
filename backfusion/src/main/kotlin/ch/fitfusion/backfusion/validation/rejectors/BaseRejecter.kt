package ch.fitfusion.backfusion.validation.rejectors

import ch.fitfusion.backfusion.api.validation.Pass
import ch.fitfusion.backfusion.api.validation.collectors.ResultCollector

open class BaseRejecter<T>(
    protected val obj: T?,
    private var pass: Pass,
) {

    fun ifNull(): ResultCollector {
        if (obj == null) {
            reject()
        } else {
            accept()
        }

        return pass
    }

    fun reject() {
        pass.isAccept = false
    }

    fun accept() {
        pass.isAccept = true
    }
}
