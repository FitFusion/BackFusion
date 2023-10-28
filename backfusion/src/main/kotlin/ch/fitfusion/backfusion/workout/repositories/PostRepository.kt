package ch.fitfusion.backfusion.workout.repositories

import ch.fitfusion.backfusion.workout.entities.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long> {

}
