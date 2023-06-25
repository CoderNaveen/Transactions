package com.naveenkumawat.transactions.domain.usecases

import androidx.lifecycle.LiveData

fun interface CalculateTotalAmountUseCase {
    fun getTotalAmount(): LiveData<Double>
}