package me.chnu.fastcampusassignment.domain.store

import jakarta.persistence.Entity
import jakarta.persistence.Table
import me.chnu.fastcampusassignment.domain.BaseEntity

@Entity
@Table(name = "stores")
internal class Store(
    var name: String,
    var location: String,
) : BaseEntity()