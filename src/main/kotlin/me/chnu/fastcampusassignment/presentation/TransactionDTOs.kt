package me.chnu.fastcampusassignment.presentation

import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.domain.transaction.Transaction
import me.chnu.fastcampusassignment.domain.transaction.TransactionStatus
import java.time.LocalDateTime

internal data class CustomerData(
    val id: Key,
)

internal data class TransactionInfo(
    val id: Key,
    val status: TransactionStatus,
    val message: String,
    val customerName: String,
    val storeName: String,
    val `when`: LocalDateTime,
) {
    companion object {
        fun from(transaction: Transaction) = TransactionInfo(
            id = transaction.id,
            status = transaction.status,
            message = transaction.message,
            customerName = transaction.customer.name,
            storeName = transaction.payment.store.name,
            `when` = transaction.createdAt!!,
        )
    }
}