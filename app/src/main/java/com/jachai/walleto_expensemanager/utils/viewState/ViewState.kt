package com.jachai.walleto_expensemanager.utils.viewState

import com.jachai.walleto_expensemanager.data.model.Transaction

sealed class ViewState {
    object Loading : ViewState()
    object Empty : ViewState()
    data class Success(val transaction: List<Transaction>) : ViewState()
    data class Error(val exception: Throwable) : ViewState()
}
