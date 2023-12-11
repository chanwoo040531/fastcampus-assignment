package me.chnu.fastcampusassignment.presentation

import me.chnu.fastcampusassignment.domain.payment.Payment
import me.chnu.fastcampusassignment.domain.payment.PaymentStatus
import me.chnu.fastcampusassignment.domain.store.Store

internal data class NewPayment(
    val storeId: Long,
    val amount: Long,
) {
    fun toPayment(store: Store) = Payment(
        status = PaymentStatus.PENDING,
        amount = amount,
        store = store,
    )
}

internal data class PaymentInfo(
    val status: PaymentStatus,
    val amount: Long,
    val store: String,

) {
    companion object {
        fun from(payment: Payment): PaymentInfo = with(payment) {
            PaymentInfo(
                status = status,
                amount = amount,
                store = store.name,
            )
        }
    }
}