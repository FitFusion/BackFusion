package ch.fitfusion.backfusion.workout.repositories

import ch.fitfusion.backfusion.auth.rbac.entities.Account
import ch.fitfusion.backfusion.workout.entities.Workout
import org.hibernate.jdbc.Work
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface WorkoutRepository : JpaRepository<Workout, Long> {

    fun findByIdAndAccount(id: Long, account: Account): Optional<Workout>
}
