package ch.fitfusion.backfusion.validation.rejectors

import ch.fitfusion.backfusion.api.validation.Pass

class StringRejecter(obj: String?, pass: Pass) : BaseRejecter<String>(obj, pass) {

    fun ifBlank() {
        if (obj.isNullOrBlank()) {
            reject()
        } else {
            accept()
        }
    }
}
