package com.example.testcmp.Common.mvvm

sealed class ErrorState {
    data class ApiAlertError(
        val title: String,
        val isCancellable: Boolean = true,
        val positiveButtonText: String = "OK",
        val positiveAction: () -> Unit = {}
    ) : ErrorState() {
        companion object {
            fun getMock() = ApiAlertError(title = "Title")
        }

    }

    data class AlertError(
        val title: String,
        val message: String,
        val isCancellable: Boolean = true,
        val positiveButtonText: String = "OK",
        val positiveAction: () -> Unit = {},
        val negativeButtonText: String = "Cancel",
        val negativeAction: () -> Unit = {}
    ) : ErrorState() {

        companion object {
            fun getMock() = AlertError(title = "Title", message = "Message")
        }


    }
}