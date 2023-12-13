package me.chnu.fastcampusassignment.domain.transaction

import me.chnu.fastcampusassignment.annotation.ReadService
import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull

@ReadService
internal class TransactionReadService(
    private val transactionRepository: TransactionRepository
) {
    fun getAll(): List<Transaction> = transactionRepository.findAll()

    fun get(transactionId: Key) = transactionRepository.findByIdOrNull(transactionId)
        ?: throw NotFoundException("입력한 결제 정보가 존재하지 않습니다.")
}