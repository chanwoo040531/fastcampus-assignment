package me.chnu.fastcampusassignment.presentation

import me.chnu.fastcampusassignment.domain.Key
import me.chnu.fastcampusassignment.domain.payment.PaymentReadService
import me.chnu.fastcampusassignment.domain.payment.PaymentWriteService
import me.chnu.fastcampusassignment.domain.store.StoreReadService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/payments")
internal class PaymentController(
    private val paymentWriteService: PaymentWriteService,
    private val paymentReadService: PaymentReadService,
    private val storeReadService: StoreReadService,
) {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun create(@RequestBody newPayment: NewPayment) {
        val store = storeReadService.get(newPayment.storeId)
        paymentWriteService.create(newPayment.toPayment(store))
    }

    @GetMapping("/{payment-id}")
    @ResponseStatus(value = HttpStatus.OK)
    fun get(@PathVariable(name = "payment-id") paymentId: Key): ApiResponse<PaymentInfo> {
        val response = paymentReadService.get(paymentId).let(PaymentInfo::from)
        return ApiResponse.success(response)
    }

    @GetMapping("/histories")
    @ResponseStatus(HttpStatus.OK)
    fun getAll() {
        val response = paymentReadService.getAll().map(PaymentInfo::from)
        ApiResponse.success(response)
    }

}