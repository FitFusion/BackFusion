package ch.fitfusion.backfusion.validation

import ch.fitfusion.backfusion.api.validation.Pass
import ch.fitfusion.backfusion.validation.rejectors.BaseRejecter
import ch.fitfusion.backfusion.validation.rejectors.StringRejecter

class Validator {
    companion object {

        fun reject(obj: Any) = BaseRejecter(obj, pass())

        fun reject(obj: String?) = StringRejecter(obj, pass())

        private fun pass() = Pass()
    }
}
