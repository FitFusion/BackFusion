package ch.fitfusion.backfusion.post.mappers

import ch.fitfusion.backfusion.api.post.dtos.CommentDTO
import ch.fitfusion.backfusion.post.entities.Comment
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CommentMapper {

    fun toDTO(entity: Comment): CommentDTO

    fun toEntity(dto: CommentDTO): Comment
}
