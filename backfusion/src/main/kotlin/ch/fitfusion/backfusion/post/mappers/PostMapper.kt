package ch.fitfusion.backfusion.post.mappers

import ch.fitfusion.backfusion.api.post.dtos.PostDTO
import ch.fitfusion.backfusion.post.entities.Post
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring", uses = [RecipeMapper::class, CommentMapper::class])
interface PostMapper {

    @Mapping(target = "account", ignore = true)
    fun toDTO(entity: Post): PostDTO

    @InheritInverseConfiguration
    fun toEntity(dto: PostDTO): Post
}
