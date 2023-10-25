package ch.fitfusion.backfusion.api.common.services

import ch.fitfusion.backfusion.api.validation.ValidationResult

interface ValidatorBase<DTO> {
    fun validate(dto: DTO): ValidationResult
}
