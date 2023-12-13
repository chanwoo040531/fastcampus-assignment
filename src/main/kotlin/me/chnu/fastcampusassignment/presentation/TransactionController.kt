package me.chnu.fastcampusassignment.presentation

import me.chnu.fastcampusassignment.application.PaymentTransactionUseCase
import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.domain.payment.Payment
import me.chnu.fastcampusassignment.domain.payment.PaymentReadService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/v1/transactions")
internal class TransactionController(
    private val paymentTransactionUseCase: PaymentTransactionUseCase,
    private val paymentReadService: PaymentReadService,
) {
    @PostMapping("/execute/{payment-id}")
    fun execute(
        @PathVariable("payment-id") paymentId: Key,
        @RequestBody customerData: CustomerData,
    ): ResponseEntity<Unit> {
        val id = paymentTransactionUseCase.processPayment(paymentId, customerData.id)

        return ResponseEntity
            .created(URI("/api/v1/transactions/histories/$id")).build()
    }

    @GetMapping("/histories")
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<Payment> = paymentReadService.getAll()

    @GetMapping("/histories/{transaction-id}")
    @ResponseStatus(HttpStatus.OK)
    fun get(@PathVariable("transaction-id") transactionId: Key) =
        paymentReadService.get(transactionId)
}