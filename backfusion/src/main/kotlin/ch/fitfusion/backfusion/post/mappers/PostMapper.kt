package ch.fitfusion.backfusion.post.mappers

import ch.fitfusion.backfusion.api.post.dtos.PostDTO
import ch.fitfusion.backfusion.post.entities.Post
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [RecipeMapper::class, CommentMapper::class])
interface PostMapper {

    fun toDTO(entity: Post): PostDTO

    fun toEntity(dto: PostDTO): Post
}
