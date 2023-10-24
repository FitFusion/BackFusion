package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.workout.dtos.WorkoutDTO
import ch.fitfusion.backfusion.workout.entities.Workout
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
interface WorkoutMapper {

    fun toDTO(entity: Workout): WorkoutDTO

    fun toEntity(dto: WorkoutDTO): Workout
}

@Component
class WorkoutMapperImpl(
    private val exerciseMapper: ExerciseMapper
) : WorkoutMapper {

    override fun toDTO(entity: Workout): WorkoutDTO {
        return WorkoutDTO(
            entity.id,
            entity.name,
            entity.description,
            entity.totalDuration,
            entity.isPublic,
            entity.exercises.map(exerciseMapper::toDTO).toList(),
        )
    }

    override fun toEntity(dto: WorkoutDTO): Workout {

        val entity = Workout()

        entity.id = dto.id
        entity.name = dto.name
        entity.description = dto.description
        entity.totalDuration = dto.totalDuration
        entity.isPublic = dto.isPublic
        entity.exercises = dto.exercises.map(exerciseMapper::toEntity).toList()
        entity.exercises.forEach { exerciseMapper.setParentEntity(it, entity) }

        return entity
    }
}
