package ch.fitfusion.backfusion.post.entities

import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Ingredient")
class Ingredient : BaseEntity() {

    @Column(length = 50)
    var name: String = ""
}
