package me.chnu.fastcampusassignment.application

import me.chnu.fastcampusassignment.annotation.UseCase
import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.domain.customer.Customer
import me.chnu.fastcampusassignment.domain.customer.CustomerReadService
import me.chnu.fastcampusassignment.domain.payment.Payment
import me.chnu.fastcampusassignment.domain.payment.PaymentReadService
import me.chnu.fastcampusassignment.domain.payment.PaymentStatus
import me.chnu.fastcampusassignment.domain.transaction.TransactionWriteService

@UseCase
internal class PaymentTransactionUseCase(
    private val customerReadService: CustomerReadService,
    private val paymentReadService: PaymentReadService,
    private val transactionWriteService: TransactionWriteService,
) {
    fun processPayment(paymentId: Key, customerId: Key): Key {
        val customer = customerReadService.get(customerId)
        val payment = paymentReadService.get(paymentId)

        if (payment.status == PaymentStatus.APPROVED) {
            return transactionWriteService
                .fail(customer, payment, "이미 처리된 거래입니다.")
        }

        if (customer.balance < payment.amount) {
            return transactionWriteService
                .fail(customer, payment, "잔액이 부족합니다.")
        }

        customer.pay(payment.amount)
        payment.confirm(payment.amount)
        return transactionWriteService.success(customer, payment)
    }
}