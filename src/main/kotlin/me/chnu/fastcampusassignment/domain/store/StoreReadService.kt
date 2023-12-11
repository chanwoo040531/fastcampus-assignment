package me.chnu.fastcampusassignment.domain.store

import me.chnu.fastcampusassignment.annotation.ReadService
import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull

@ReadService
internal class StoreReadService(
    private val storeRepository: StoreRepository
) {

    fun get(id: Key): Store = storeRepository.findByIdOrNull(id)
        ?: throw NotFoundException("입력한 매장 정보와 일치하는 데이터가 없습니다.")
}