package com.naveenkumawat.transactions

import androidx.lifecycle.LiveData

fun interface CalculateTotalAmountUseCase {
    fun getTotalAmount(): LiveData<Double>
}