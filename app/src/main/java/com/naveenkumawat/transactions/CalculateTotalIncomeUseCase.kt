package com.naveenkumawat.transactions

import androidx.lifecycle.LiveData

fun interface CalculateTotalIncomeUseCase {
    fun getIncomeTotal(): LiveData<Double>
}