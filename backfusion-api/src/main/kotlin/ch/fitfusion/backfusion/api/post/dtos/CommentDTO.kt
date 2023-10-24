package ch.fitfusion.backfusion.api.post.dtos

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import java.util.Date

class CommentDTO(
    val id: Long?,
    val text: String,
    val likes: Long,
    val creationDate: Date,
    val account: AccountDTO,
)
