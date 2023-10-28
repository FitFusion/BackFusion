package ch.fitfucion.backfusion.post.services

import ch.fitfusion.backfusion.api.post.dtos.CommentDTO
import ch.fitfusion.backfusion.api.post.dtos.PostDTO
import ch.fitfusion.backfusion.api.post.services.PostService

class PostServiceImpl : PostService {
    override fun createPost(postDto: PostDTO): PostDTO {
        TODO("Not yet implemented")
    }

    override fun createComment(id: Long, commentDto: CommentDTO): CommentDTO {
        TODO("Not yet implemented")
    }

    override fun getPost(id: String): PostDTO {
        TODO("Not yet implemented")
    }

    override fun getPosts(): List<PostDTO> {
        TODO("Not yet implemented")
    }
}