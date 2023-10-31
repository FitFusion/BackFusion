package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.workout.dtos.ExerciseDTO
import ch.fitfusion.backfusion.workout.entities.Exercise
import ch.fitfusion.backfusion.workout.entities.Workout
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper
interface ExerciseMapper {

    fun toDTO(entity: Exercise): ExerciseDTO

    fun toEntity(dto: ExerciseDTO): Exercise

    fun setParentEntity(child: Exercise, parent: Workout) {
        child.workout = parent
    }
}

//@Component
//class ExerciseMapperImpl : ExerciseMapper {
//
//    override fun toDTO(entity: Exercise): ExerciseDTO {
//        return ExerciseDTO(
//            entity.id ?: -1,
//            entity.name,
//            entity.duration,
//        )
//    }
//
//    override fun toEntity(dto: ExerciseDTO): Exercise {
//        val entity = Exercise()
//
//        entity.id = dto.id
//        entity.name = dto.name
//        entity.duration = dto.duration
//
//        return entity
//    }
//}
