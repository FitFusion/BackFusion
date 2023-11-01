package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.workout.dtos.ExerciseDTO
import ch.fitfusion.backfusion.workout.entities.Exercise
import ch.fitfusion.backfusion.workout.entities.Workout
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
abstract class ExerciseMapper {

    @InheritInverseConfiguration
    abstract fun toDTO(entity: Exercise): ExerciseDTO

    @Mapping(target = "workout", ignore = true)
    abstract fun toEntity(dto: ExerciseDTO): Exercise

    fun setParentEntity(child: Exercise, parent: Workout) {
        child.workout = parent
    }
}
