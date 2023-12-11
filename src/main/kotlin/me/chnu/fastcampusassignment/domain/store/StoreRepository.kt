package me.chnu.fastcampusassignment.domain.store

import me.chnu.fastcampusassignment.domain.Key
import org.springframework.data.jpa.repository.JpaRepository

internal interface StoreRepository : JpaRepository<Store, Key>