package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.post.dtos.PostDTO
import ch.fitfusion.backfusion.workout.entities.Post
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
interface PostMapper {

    fun toDTO(entity: Post): PostDTO

    fun toEntity(dto: PostDTO): Post
}

@Component
class PostMapperImpl(
    private val accountMapper: AccountMapper,
    private val recipeMapper: RecipeMapper,
) : PostMapper {
    override fun toDTO(entity: Post): PostDTO {
        return PostDTO(
            id = entity.id ?: -1,
            title = entity.title,
            content = entity.content,
            recipe = if (entity.recipe == null) null else recipeMapper.toDTO(entity.recipe!!),
            account = if(entity.account == null) null else accountMapper.toDTO(entity.account!!),
            creationDate = entity.creationDate,
            likes = null,
            comments = listOf(),
            image = null
        );
    }

    override fun toEntity(dto: PostDTO): Post {
        val entity = Post()

        entity.id = dto.id;
        entity.recipe = if(dto.recipe == null) null else recipeMapper.toEntity(dto.recipe!!)
        entity.content = dto.content ?: ""
        entity.title = dto.title
        entity.account = if(dto.account == null) null else accountMapper.getAccount(dto.account!!)
        entity.creationDate = dto.creationDate

        return entity
    }
}
