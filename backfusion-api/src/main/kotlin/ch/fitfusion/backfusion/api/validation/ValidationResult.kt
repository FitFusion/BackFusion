package ch.fitfusion.backfusion.api.validation

class ValidationResult {

    val errors: ArrayList<ValidationResultEntry> = ArrayList()

    val warnings: ArrayList<ValidationResultEntry> = ArrayList()

    val infos: ArrayList<ValidationResultEntry> = ArrayList()

    companion object {

        fun ok(): ValidationResult {
            return ValidationResult()
        }

        fun withError(error: ValidationResultEntry): ValidationResult {

            val res = ValidationResult()
            res.addError(error)

            return res
        }
    }

    fun addError(error: ValidationResultEntry) {
        errors.add(error)
    }

    fun addWarning(warning: ValidationResultEntry) {
        warnings.add(warning)
    }

    fun addInfo(info: ValidationResultEntry) {
        infos.add(info)
    }

    fun isOk(): Boolean {
        return errors.isEmpty()
                && warnings.isEmpty()
    }

    fun isNotOk(): Boolean {
        return !isOk()
    }

}
