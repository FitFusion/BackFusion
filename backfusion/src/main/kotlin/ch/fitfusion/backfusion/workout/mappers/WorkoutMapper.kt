package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.workout.dtos.WorkoutDTO
import ch.fitfusion.backfusion.workout.entities.Workout
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface WorkoutMapper {

    fun toDTO(entity: Workout): WorkoutDTO

    fun toEntity(dto: WorkoutDTO): Workout
}
