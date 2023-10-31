package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.workout.dtos.ExerciseDTO
import ch.fitfusion.backfusion.workout.entities.Exercise
import ch.fitfusion.backfusion.workout.entities.Workout
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class ExerciseMapper {

    abstract fun toDTO(entity: Exercise): ExerciseDTO

    abstract fun toEntity(dto: ExerciseDTO): Exercise

    fun setParentEntity(child: Exercise, parent: Workout) {
        child.workout = parent
    }
}
