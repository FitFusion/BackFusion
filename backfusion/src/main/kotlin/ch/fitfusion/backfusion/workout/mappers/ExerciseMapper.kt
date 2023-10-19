package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.workout.dtos.ExerciseDTO
import ch.fitfusion.backfusion.workout.entities.Exercise
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ExerciseMapper {

    fun toDTO(entity: Exercise): ExerciseDTO

    fun toEntity(dto: ExerciseDTO): Exercise
}
