package ch.fitfusion.backfusion.post.entities

import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Post")
class Recipe : BaseEntity() {

    @ElementCollection
    var ingredients: List<String> = mutableListOf()

    @OneToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    var post: Post? = null
}
