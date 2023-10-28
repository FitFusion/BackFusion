package ch.fitfusion.backfusion.validation.rejectors

import ch.fitfusion.backfusion.api.validation.Pass
import ch.fitfusion.backfusion.api.validation.collectors.ResultCollector

class StringRejecter(obj: String?, pass: Pass) : BaseRejecter<String>(obj, pass) {

    fun ifBlank(): ResultCollector {

        if (obj!!.isBlank()) {
            reject()
        } else {
            accept()
        }

        return pass
    }

    fun ifNullOrBlank(): ResultCollector {

        if (obj.isNullOrBlank()) {
            reject()
        } else {
            accept()
        }

        return pass
    }
}
