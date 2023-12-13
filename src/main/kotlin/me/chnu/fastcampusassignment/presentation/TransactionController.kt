package me.chnu.fastcampusassignment.presentation

import me.chnu.fastcampusassignment.application.PaymentTransactionUseCase
import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.domain.transaction.TransactionReadService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/v1/transactions")
internal class TransactionController(
    private val paymentTransactionUseCase: PaymentTransactionUseCase,
    private val transactionReadService: TransactionReadService,
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
    fun getAll(): ApiResponse<List<TransactionInfo>> {
        val response = transactionReadService.getAll().map(TransactionInfo::from)

        return ApiResponse.success(response)
    }


    @GetMapping("/histories/{transaction-id}")
    @ResponseStatus(HttpStatus.OK)
    fun get(@PathVariable("transaction-id") transactionId: Key): ApiResponse<TransactionInfo> {
        val response = transactionReadService.get(transactionId).let(TransactionInfo::from)

        return ApiResponse.success(response)
    }
}