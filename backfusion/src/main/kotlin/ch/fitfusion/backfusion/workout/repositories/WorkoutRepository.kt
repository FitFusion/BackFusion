package ch.fitfusion.backfusion.workout.repositories

import ch.fitfusion.backfusion.workout.entities.Workout
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkoutRepository : JpaRepository<Workout, Long> {
}
