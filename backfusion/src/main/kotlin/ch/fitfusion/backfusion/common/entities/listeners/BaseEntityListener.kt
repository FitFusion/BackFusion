package ch.fitfusion.backfusion.common.entities.listeners

import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.PrePersist
import org.springframework.stereotype.Component
import java.util.*

@Component
class BaseEntityListener {

    @PrePersist
    fun beforeSave(baseEntity: BaseEntity) {
        // Set creation date
        baseEntity.creationDate = Date()
    }
}
