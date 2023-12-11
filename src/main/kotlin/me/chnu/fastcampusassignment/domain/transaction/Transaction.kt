package me.chnu.fastcampusassignment.domain.transaction

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import me.chnu.fastcampusassignment.domain.BaseEntity
import me.chnu.fastcampusassignment.domain.customer.Customer
import me.chnu.fastcampusassignment.domain.payment.Payment

@Entity
@Table(name = "transactions")
internal class Transaction(

    @Enumerated(EnumType.STRING)
    var status: TransactionStatus,

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    val customer: Customer,

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    val payment: Payment,

) : BaseEntity()