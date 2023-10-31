package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.workout.dtos.WorkoutDTO
import ch.fitfusion.backfusion.workout.entities.Workout
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(componentModel = "spring", uses = [ExerciseMapper::class])
abstract class WorkoutMapper(
    protected val exerciseMapper: ExerciseMapper
) {

    abstract fun toDTO(entity: Workout): WorkoutDTO

    abstract fun toEntity(dto: WorkoutDTO): Workout

    @AfterMapping
    fun addParentEntity(@MappingTarget entity: Workout) {
        entity.exercises.forEach { exerciseMapper.setParentEntity(it, entity) }
    }
}
