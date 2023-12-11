package me.chnu.fastcampusassignment.domain.payment

internal enum class PaymentStatus(val status: String) {
    PENDING("PENDING"),
    APPROVED("APPROVED"),
    DENIED("DENIED"),
}
