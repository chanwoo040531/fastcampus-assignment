package me.chnu.fastcampusassignment.domain.customer

import jakarta.persistence.Entity
import jakarta.persistence.Table
import me.chnu.fastcampusassignment.domain.BaseEntity

@Entity
@Table(name = "customers")
internal class Customer(
    var name: String,

) : BaseEntity()