package me.chnu.fastcampusassignment.presentation

import me.chnu.fastcampusassignment.exception.NotFoundException
import me.chnu.fastcampusassignment.exception.ServerException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import kotlin.Exception

@RestControllerAdvice
internal class ExceptionController {
    private val logger = KotlinLogging.logger { }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun handleNotFoundException(ex: NotFoundException): ApiResponse<Unit> {
        logger.error { ex.message }
        return ApiResponse.error(message = ex.message)
    }

    @ExceptionHandler(ServerException::class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerException(ex: ServerException): ApiResponse<Unit> {
        logger.error { ex.message }
        return ApiResponse.error(message = ex.message)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(ex: Exception): ApiResponse<Unit> {
        logger.error { ex.message }
        return ApiResponse.error(message = "Internal Server Error")
    }

}