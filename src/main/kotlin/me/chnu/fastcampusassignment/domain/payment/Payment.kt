package me.chnu.fastcampusassignment.domain.payment

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import me.chnu.fastcampusassignment.domain.BaseEntity
import me.chnu.fastcampusassignment.domain.store.Store

@Entity
@Table(name = "payments")
internal class Payment(

    @Enumerated(EnumType.STRING)
    var status: PaymentStatus,

    val amount: Long,

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    val store: Store
) : BaseEntity()