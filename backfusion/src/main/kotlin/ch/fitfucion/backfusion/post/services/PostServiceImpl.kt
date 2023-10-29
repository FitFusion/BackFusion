package ch.fitfucion.backfusion.post.services

import ch.fitfusion.backfusion.account.util.AccountUtil
import ch.fitfusion.backfusion.api.post.dtos.CommentDTO
import ch.fitfusion.backfusion.api.post.dtos.PostDTO
import ch.fitfusion.backfusion.api.post.services.PostService
import ch.fitfusion.backfusion.workout.mappers.PostMapper
import ch.fitfusion.backfusion.workout.repositories.PostRepository
import ch.fitfusion.backfusion.workout.services.validation.PostValidator
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    private val validator: PostValidator,
    private val postMapper: PostMapper,
    private val accountUtil: AccountUtil,
    private val postRepository: PostRepository,
) : PostService {
    override fun createPost(postDto: PostDTO): PostDTO {
        val validationResult = validator.validate(postDto)

        val post = postMapper.toEntity(postDto)
        if(post.account == null)
            post.account = accountUtil.getAccountFromContext()

        return postMapper.toDTO(postRepository.save(post))
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
