package ch.fitfusion.backfusion.post.mappers

import ch.fitfusion.backfusion.api.post.dtos.RecipeDTO
import ch.fitfusion.backfusion.post.entities.Recipe
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface RecipeMapper {

    fun toDTO(entity: Recipe): RecipeDTO

    fun toEntity(dto: RecipeDTO): Recipe
}
