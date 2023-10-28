package ch.fitfusion.backfusion.rs.api.authenticated

import ch.fitfusion.backfusion.api.post.dtos.CommentDTO
import ch.fitfusion.backfusion.api.post.dtos.PostDTO
import ch.fitfusion.backfusion.auth.rbac.annotations.AccessibleByUser
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

interface PostResourceService{
    @PostMapping
    @AccessibleByUser
    fun createPost(@RequestBody postDto: PostDTO) : ResponseEntity<PostDTO>

    @PostMapping("/{id}")
    @AccessibleByUser
    fun createComment(@PathVariable id: Long, @RequestBody commentDto: CommentDTO) : ResponseEntity<CommentDTO>

    @GetMapping("/{id}")
    @AccessibleByUser
    fun getPost(@PathVariable id: String) : ResponseEntity<PostDTO>

    @GetMapping
    @AccessibleByUser
    fun getPosts() : ResponseEntity<List<PostDTO>>
}