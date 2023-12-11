package me.chnu.fastcampusassignment.domain.customer

import me.chnu.fastcampusassignment.annotation.ReadService
import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull

@ReadService
internal class CustomerReadService(
    private val customerRepository: CustomerRepository,
) {
    fun get(id: Key): Customer = customerRepository.findByIdOrNull(id)
        ?: throw NotFoundException("입력한 고객 정보와 일치하는 데이터가 없습니다.")
}