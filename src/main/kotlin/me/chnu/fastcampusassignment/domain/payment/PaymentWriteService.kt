package me.chnu.fastcampusassignment.domain.payment

import me.chnu.fastcampusassignment.annotation.WriteService
import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.domain.store.Store
import me.chnu.fastcampusassignment.exception.NotFoundException
import me.chnu.fastcampusassignment.presentation.NewPayment
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@WriteService
internal class PaymentWriteService(
    private val paymentRepository: PaymentRepository,
) {
    fun create(payment: Payment) =
        paymentRepository.save(payment)
}