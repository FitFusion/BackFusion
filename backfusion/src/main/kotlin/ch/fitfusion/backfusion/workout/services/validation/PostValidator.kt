package ch.fitfusion.backfusion.workout.services.validation

import ch.fitfusion.backfusion.api.common.services.ValidatorBase
import ch.fitfusion.backfusion.api.post.dtos.PostDTO
import ch.fitfusion.backfusion.api.validation.ValidationResult
import org.springframework.stereotype.Component

@Component
class PostValidator : ValidatorBase<PostDTO> {
    override fun validate(dto: PostDTO): ValidationResult {
        return ValidationResult.ok();
    }
}
