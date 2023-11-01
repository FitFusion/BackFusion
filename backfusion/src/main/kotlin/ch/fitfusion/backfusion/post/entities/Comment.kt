package ch.fitfusion.backfusion.post.entities

import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Comment")
class Comment : BaseEntity() {

    @Column(length = 512)
    var content: String = ""

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    var post: Post? = null
}
