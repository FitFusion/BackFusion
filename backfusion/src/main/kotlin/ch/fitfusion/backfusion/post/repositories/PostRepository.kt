package ch.fitfusion.backfusion.post.repositories

import ch.fitfusion.backfusion.workout.entities.Workout
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Workout, Long> {
}
