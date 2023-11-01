package ch.fitfusion.backfusion.post.mappers

import ch.fitfusion.backfusion.api.post.dtos.RecipeDTO
import ch.fitfusion.backfusion.post.entities.Recipe
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface RecipeMapper {

    @Mapping(target = "post", ignore = true)
    fun toDTO(entity: Recipe): RecipeDTO

    @InheritInverseConfiguration
    fun toEntity(dto: RecipeDTO): Recipe
}
