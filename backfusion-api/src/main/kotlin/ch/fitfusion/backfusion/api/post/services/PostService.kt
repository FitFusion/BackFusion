package ch.fitfusion.backfusion.api.post.services

import ch.fitfusion.backfusion.api.post.dtos.CommentDTO
import ch.fitfusion.backfusion.api.post.dtos.PostDTO

interface PostService{
    fun createPost(postDto: PostDTO) : PostDTO

    fun createComment(id: Long, commentDto: CommentDTO) : CommentDTO

    fun getPost(id: String) : PostDTO

    fun getPosts() : List<PostDTO>
}