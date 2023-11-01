package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.workout.dtos.ExerciseDTO
import ch.fitfusion.backfusion.testutils.getDefaultDate
import ch.fitfusion.backfusion.workout.entities.Exercise
import ch.fitfusion.backfusion.workout.entities.Workout
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers

class ExerciseMapperTest {

    private val exerciseMapper = Mappers.getMapper(ExerciseMapper::class.java)

    @Test
    fun `Test toDTO correctly maps Exercise to DTO`() {

        val exerciseDTO = exerciseMapper.toDTO(createExercise())

        assertEquals(5L, exerciseDTO.id)
        assertEquals("Lift weights", exerciseDTO.name)
        assertEquals(443, exerciseDTO.duration)
    }

    @Test
    fun `Test toEntity correctly maps ExerciseDTO to Exercise`() {
        val exercise = exerciseMapper.toEntity(createExerciseDTO())

        assertEquals(6L, exercise.id)
        assertEquals("Don't lift weights", exercise.name)
        assertEquals(550, exercise.duration)
    }

    @Test
    fun `Test parent entity correctly set in Exercise`() {

        val workout = Workout()
        val exercise = createExercise()

        exerciseMapper.setParentEntity(exercise, workout)

        assertEquals(workout, exercise.workout)
    }

    private fun createExercise(): Exercise {

        val exercise = Exercise()

        exercise.id = 5L
        exercise.name = "Lift weights"
        exercise.creationDate = getDefaultDate()
        exercise.duration = 443
        exercise.workout = null

        return exercise
    }

    private fun createExerciseDTO(): ExerciseDTO {
        return ExerciseDTO(
            6L,
            "Don't lift weights",
            550
        )
    }
}
