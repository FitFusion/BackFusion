package ch.fitfusion.backfusion.workout.services.validation

import ch.fitfusion.backfusion.api.validation.ValidationResult
import ch.fitfusion.backfusion.api.common.services.ValidatorBase
import ch.fitfusion.backfusion.api.workout.dtos.WorkoutDTO
import org.springframework.stereotype.Component

@Component
class WorkoutValidator : ValidatorBase<WorkoutDTO> {

    override fun validate(dto: WorkoutDTO): ValidationResult {
        return ValidationResult.ok()
    }
}
