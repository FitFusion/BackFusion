package ch.fitfusion.backfusion.common.entities.converters

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class StringConverter : AttributeConverter<String, String> {

    override fun convertToDatabaseColumn(entityData: String?) = entityData

    override fun convertToEntityAttribute(dbData: String?) = dbData ?: ""
}
