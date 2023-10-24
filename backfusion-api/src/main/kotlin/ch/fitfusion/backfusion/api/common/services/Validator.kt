package ch.fitfusion.backfusion.api.common.services

import ch.fitfusion.backfusion.api.common.dtos.ValidationResult

interface Validator<DTO> {

    fun validate(dto: DTO): ValidationResult
}
