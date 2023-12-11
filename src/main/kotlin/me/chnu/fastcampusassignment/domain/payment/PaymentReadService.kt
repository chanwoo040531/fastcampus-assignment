package me.chnu.fastcampusassignment.domain.payment

import me.chnu.fastcampusassignment.annotation.ReadService
import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull

@ReadService
internal class PaymentReadService(
    private val paymentRepository: PaymentRepository
) {
    fun get(paymentId: Key) = paymentRepository.findByIdOrNull(paymentId)
        ?: throw NotFoundException("입력한 거래 정보가 존재하지 않습니다.")
}
