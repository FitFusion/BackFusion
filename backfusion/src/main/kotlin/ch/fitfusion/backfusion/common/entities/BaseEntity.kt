package ch.fitfusion.backfusion.common.entities

import jakarta.persistence.*
import java.util.*

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column
    var creationDate: Date = Date()
}
