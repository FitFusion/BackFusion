package ch.fitfusion.backfusion.workout.entities

import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Ingredient")
class Ingredient : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(length = 50)
    var name: String = ""
}
