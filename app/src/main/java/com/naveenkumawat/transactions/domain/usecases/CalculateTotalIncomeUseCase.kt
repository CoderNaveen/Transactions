package com.naveenkumawat.transactions.domain.usecases

import androidx.lifecycle.LiveData

fun interface CalculateTotalIncomeUseCase {
    fun getIncomeTotal(): LiveData<Double>
}