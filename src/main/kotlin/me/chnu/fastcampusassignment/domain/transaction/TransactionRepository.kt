package me.chnu.fastcampusassignment.domain.transaction

import me.chnu.fastcampusassignment.domain.Key
import org.springframework.data.jpa.repository.JpaRepository

internal interface TransactionRepository : JpaRepository<Transaction, Key>