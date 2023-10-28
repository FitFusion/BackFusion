package ch.fitfusion.backfusion.rs.server.authenticated

import ch.fitfusion.backfusion.api.post.dtos.CommentDTO
import ch.fitfusion.backfusion.api.post.dtos.PostDTO
import ch.fitfusion.backfusion.api.post.services.PostService
import ch.fitfusion.backfusion.rs.api.authenticated.PostResourceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
open class PostResourceServiceImpl(
    private val postService: PostService
) : PostResourceService{
    override fun createPost(postDto: PostDTO): ResponseEntity<PostDTO> {
        return ResponseEntity.ok(postService.createPost(postDto))
    }

    override fun createComment(id: Long, commentDto: CommentDTO): ResponseEntity<CommentDTO> {
        return ResponseEntity.ok(postService.createComment(id, commentDto))
    }

    override fun getPost(id: String): ResponseEntity<PostDTO> {
        return ResponseEntity.ok(postService.getPost(id));
    }

    override fun getPosts(): ResponseEntity<List<PostDTO>> {
        return ResponseEntity.ok(postService.getPosts())
    }
}