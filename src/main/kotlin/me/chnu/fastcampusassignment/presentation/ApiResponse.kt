package me.chnu.fastcampusassignment.presentation

internal class ApiResponse<T>(
    val message: String? = "",
    val body: T? = null,
) {
    companion object {
        fun error(message: String?): ApiResponse<Unit> = ApiResponse(message = message)

        fun <T> success(body: T?): ApiResponse<T> = ApiResponse(body = body)
    }
}