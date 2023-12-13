package me.chnu.fastcampusassignment.domain.transaction

import me.chnu.fastcampusassignment.annotation.WriteService
import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.domain.customer.Customer
import me.chnu.fastcampusassignment.domain.payment.Payment

@WriteService
internal class TransactionWriteService(
    private val transactionRepository: TransactionRepository
) {

    fun fail(customer: Customer, payment: Payment, message: String): Key {
        val transaction = Transaction(
            status = TransactionStatus.FAIL,
            message = message,
            customer = customer,
            payment = payment,
        )
        val savedTransaction = transactionRepository.save(transaction)
        return savedTransaction.id
    }

    fun success(customer: Customer, payment: Payment): Key {
        val transaction = Transaction(
            status = TransactionStatus.SUCCESS,
            message = "결제에 성공하였습니다.",
            customer = customer,
            payment = payment,
        )

        val savedTransaction = transactionRepository.save(transaction)
        return savedTransaction.id
    }
}
