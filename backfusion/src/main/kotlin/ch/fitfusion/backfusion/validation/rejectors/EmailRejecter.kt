package ch.fitfusion.backfusion.validation.rejectors

import ch.fitfusion.backfusion.api.validation.Pass
import ch.fitfusion.backfusion.api.validation.collectors.ResultCollector
import java.util.regex.Pattern

class EmailRejecter(obj: String?, pass: Pass) : BaseRejecter<String>(obj, pass) {

    fun ifInvalid(): ResultCollector {

        val emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$"

        if (obj == null || !Pattern.matches(emailPattern, obj)) {
            reject()
        } else {
            accept()
        }

        return pass
    }
}
