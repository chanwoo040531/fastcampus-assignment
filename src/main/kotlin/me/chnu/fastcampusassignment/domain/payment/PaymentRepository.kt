package me.chnu.fastcampusassignment.domain.payment

import me.chnu.fastcampusassignment.domain.Key
import org.springframework.data.jpa.repository.JpaRepository

internal interface PaymentRepository : JpaRepository<Payment, Key>