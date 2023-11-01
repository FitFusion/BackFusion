package ch.fitfusion.backfusion.post.mappers

import ch.fitfusion.backfusion.api.post.dtos.CommentDTO
import ch.fitfusion.backfusion.post.entities.Comment
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CommentMapper {

    @Mapping(target = "account", ignore = true)
    @Mapping(target = "post", ignore = true)
    fun toDTO(entity: Comment): CommentDTO

    @InheritInverseConfiguration
    fun toEntity(dto: CommentDTO): Comment
}
