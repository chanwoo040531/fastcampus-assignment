package me.chnu.fastcampusassignment.domain.customer

import me.chnu.fastcampusassignment.domain.Key
import org.springframework.data.jpa.repository.JpaRepository

internal interface CustomerRepository : JpaRepository<Customer, Key>