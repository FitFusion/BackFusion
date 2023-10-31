package ch.fitfusion.backfusion.post.repositories

import ch.fitfusion.backfusion.post.entities.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long> {

}
