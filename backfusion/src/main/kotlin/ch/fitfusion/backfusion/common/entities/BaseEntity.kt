package ch.fitfusion.backfusion.common.entities

import jakarta.persistence.Column
import java.util.*

abstract class BaseEntity {

    @Column
    var creationDate: Date = Date()
}
