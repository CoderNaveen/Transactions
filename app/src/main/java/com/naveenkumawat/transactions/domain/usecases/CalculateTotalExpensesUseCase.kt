package com.naveenkumawat.transactions.domain.usecases

import androidx.lifecycle.LiveData

fun interface CalculateTotalExpensesUseCase {
    fun getExpenseTotal(): LiveData<Double>
}