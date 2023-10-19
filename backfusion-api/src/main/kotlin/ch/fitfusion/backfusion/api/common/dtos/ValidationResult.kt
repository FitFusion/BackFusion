package ch.fitfusion.backfusion.api.common.dtos

class ValidationResult() {

    var errors: ArrayList<String> = ArrayList()

    constructor(error: String) : this() {
        this.errors.add(error)
    }

    companion object {

        fun ok(): ValidationResult {
            return ValidationResult()
        }

        fun withError(error: String): ValidationResult {
            return ValidationResult(error)
        }
    }

    fun addError(error: String) {
        errors.add(error)
    }

}
