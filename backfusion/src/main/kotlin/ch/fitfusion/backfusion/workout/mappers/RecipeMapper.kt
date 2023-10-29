package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.post.dtos.RecipeDTO
import ch.fitfusion.backfusion.workout.entities.Ingredient
import ch.fitfusion.backfusion.workout.entities.Recipe
import org.mapstruct.Mapper
import org.springframework.stereotype.Component
import java.util.Date

@Mapper(componentModel = "spring")
interface RecipeMapper {
    fun toDTO(entity: Recipe): RecipeDTO

    fun toEntity(dto: RecipeDTO): Recipe
}

@Component
class RecipeMapperImpl : RecipeMapper{
    override fun toDTO(entity: Recipe): RecipeDTO {
        return RecipeDTO(entity.id, entity.ingredients.map { it.name })
    }

    override fun toEntity(dto: RecipeDTO): Recipe {
        val recipe = Recipe()
        recipe.id = dto.id
        recipe.creationDate = Date()
        recipe.ingredients = dto.ingredients.map {
            val ingredient = Ingredient()
            ingredient.name = it
            ingredient;
        }
        return recipe;
    }

}
