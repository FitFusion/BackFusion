package ch.fitfusion.backfusion.account.entities

import ch.fitfusion.backfusion.account.entities.listeners.AccountListener
import ch.fitfusion.backfusion.common.entities.BaseEntity
import ch.fitfusion.backfusion.post.entities.Comment
import ch.fitfusion.backfusion.post.entities.Post
import ch.fitfusion.backfusion.workout.entities.Workout
import jakarta.persistence.*


@Entity
@Table(name = "Account")
@EntityListeners(AccountListener::class)
class Account : BaseEntity() {

    @Column
    var username: String = ""

    @Column
    var password: String = ""

    @Column
    var email: String = ""

    @Column
    var emailVerified: Boolean = false

    @Column
    var secondFactorEnabled: Boolean = false

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "Account_Authority",
        joinColumns = [JoinColumn(name = "account_id")],
        inverseJoinColumns = [JoinColumn(name = "authority_id")]
    )
    var authorities: Set<Authority> = HashSet()

    @OneToMany(
        mappedBy = "account",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var workouts: List<Workout> = mutableListOf()

    @OneToMany(
        mappedBy = "account",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var posts: List<Post> = mutableListOf()

    @OneToMany(
        mappedBy = "account",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var comments: List<Comment> = mutableListOf()
}
