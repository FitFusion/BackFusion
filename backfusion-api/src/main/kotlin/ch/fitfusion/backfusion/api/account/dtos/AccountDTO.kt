package ch.fitfusion.backfusion.api.account.dtos

class AccountDTO(
    var username: String,
    var email: String,
    var emailVerified: Boolean,
    var secondFactorEnabled: Boolean,
)
