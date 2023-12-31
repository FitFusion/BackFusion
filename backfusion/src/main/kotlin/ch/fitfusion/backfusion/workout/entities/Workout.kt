package ch.fitfusion.backfusion.workout.entities

import ch.fitfusion.backfusion.account.entities.Account
import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Workout")
class Workout : BaseEntity() {

    @Column(length = 50)
    var name: String = ""

    @Column(length = 250)
    var description: String = ""

    @Column
    var totalDuration: Int = 0

    @Column
    var isPublic: Boolean = false

    @OneToMany(
        mappedBy = "workout",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var exercises: List<Exercise> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    var account: Account? = null
}
