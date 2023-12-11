package me.chnu.fastcampusassignment.application

import me.chnu.fastcampusassignment.annotation.UseCase
import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.domain.customer.Customer
import me.chnu.fastcampusassignment.domain.customer.CustomerReadService
import me.chnu.fastcampusassignment.domain.payment.Payment
import me.chnu.fastcampusassignment.domain.payment.PaymentReadService
import me.chnu.fastcampusassignment.domain.payment.PaymentStatus
import me.chnu.fastcampusassignment.domain.transaction.TransactionStatus
import me.chnu.fastcampusassignment.domain.transaction.TransactionWriteService
import me.chnu.fastcampusassignment.exception.TransactionException

@UseCase
internal class PaymentTransactionUseCase(
    private val customerReadService: CustomerReadService,
    private val paymentReadService: PaymentReadService,
    private val transactionWriteService: TransactionWriteService,
) {
    fun processPayment(paymentId: Key, customerId: Key) {
        val customer = customerReadService.get(customerId)
        val payment = paymentReadService.get(paymentId)

        validate(customer, payment)

        customer.pay(payment.amount)
        payment.confirm()
        transactionWriteService.success(customer, payment)
    }

    private fun validate(customer: Customer, payment: Payment) {
        if (payment.status == PaymentStatus.APPROVED) {
            transactionWriteService.fail(customer, payment, "이미 처리된 거래입니다.")
        }

        if (payment.status == PaymentStatus.DENIED) {
            transactionWriteService.fail(customer, payment, "거래에 이상이 발생하였습니다.")
        }

        if (customer.balance < payment.amount) {
            transactionWriteService.fail(customer, payment, "잔액이 부족합니다.")
        }
    }
}