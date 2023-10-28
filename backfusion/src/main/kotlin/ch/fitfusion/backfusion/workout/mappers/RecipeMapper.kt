package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.post.dtos.RecipeDTO
import ch.fitfusion.backfusion.workout.entities.Recipe
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface RecipeMapper {
    fun toDTO(entity: Recipe): RecipeDTO

    fun toEntity(dto: RecipeDTO): Recipe
}

class RecipeMapperImpl : RecipeMapper{
    override fun toDTO(entity: Recipe): RecipeDTO {
        return RecipeDTO(entity.id, entity.ingredients.map { it.name })
    }

    override fun toEntity(dto: RecipeDTO): Recipe {
        
    }

}
