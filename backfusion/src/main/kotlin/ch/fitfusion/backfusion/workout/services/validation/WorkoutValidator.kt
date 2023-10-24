package ch.fitfusion.backfusion.workout.services.validation

import ch.fitfusion.backfusion.api.common.dtos.ValidationResult
import ch.fitfusion.backfusion.api.common.services.Validator
import ch.fitfusion.backfusion.api.workout.dtos.WorkoutDTO
import org.springframework.stereotype.Component

@Component
class WorkoutValidator : Validator<WorkoutDTO> {

    override fun validate(dto: WorkoutDTO): ValidationResult {
        return ValidationResult.ok()
    }
}
