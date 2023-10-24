package ch.fitfusion.backfusion.workout.repositories

import ch.fitfusion.backfusion.workout.entities.Exercise
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExerciseRepository : JpaRepository<Exercise, Long> {
}
