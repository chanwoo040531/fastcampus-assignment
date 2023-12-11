package me.chnu.fastcampusassignment.domain.payment

import me.chnu.fastcampusassignment.annotation.WriteService

@WriteService
internal class PaymentWriteService(
    private val paymentRepository: PaymentRepository,
) {
    fun create(payment: Payment) =
        paymentRepository.save(payment)
}