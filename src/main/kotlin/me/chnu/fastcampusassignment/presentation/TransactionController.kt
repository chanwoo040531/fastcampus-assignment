package me.chnu.fastcampusassignment.presentation

import me.chnu.fastcampusassignment.application.PaymentTransactionUseCase
import me.chnu.fastcampusassignment.domain.Key
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/transactions")
internal class TransactionController(
    private val paymentTransactionUseCase: PaymentTransactionUseCase,
) {
    @PostMapping("/execute/{payment-id}")
    fun execute(
        @PathVariable("payment-id") paymentId: Key,
        @RequestBody customerData: CustomerData,
    ) {
        paymentTransactionUseCase.processPayment(paymentId, customerData.id)
    }

    @GetMapping("/histories")
    fun getAll() {

    }
}