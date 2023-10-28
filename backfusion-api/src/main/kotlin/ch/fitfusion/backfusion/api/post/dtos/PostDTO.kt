package ch.fitfusion.backfusion.api.post.dtos

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import java.util.*

class PostDTO(
    val id: Long?,
    val title: String,
    val content: String?,
    val recipe: RecipeDTO?,
    val account: AccountDTO?,
    val creationDate: Date,
    val likes: Long?,
    val comments: List<CommentDTO>,
    val image: String?,
)
