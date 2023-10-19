package ch.fitfusion.backfusion.workout.entities

import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Exercise")
class Exercise : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(length = 50)
    var name: String = ""

    @Column
    var duration: Int = 0

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    var workout: Workout? = null
}
