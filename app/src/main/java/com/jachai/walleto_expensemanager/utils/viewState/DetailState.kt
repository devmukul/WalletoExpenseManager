package com.jachai.walleto_expensemanager.utils.viewState

import com.jachai.walleto_expensemanager.data.model.Transaction

sealed class DetailState {
    object Loading : DetailState()
    object Empty : DetailState()
    data class Success(val transaction: Transaction) : DetailState()
    data class Error(val exception: Throwable) : DetailState()
}
