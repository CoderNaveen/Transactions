package com.naveenkumawat.transactions

import androidx.lifecycle.LiveData

fun interface CalculateTotalExpensesUseCase {
    fun getExpenseTotal(): LiveData<Double>
}