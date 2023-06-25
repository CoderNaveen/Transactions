package com.naveenkumawat.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class TransactionViewModelFactory(private val repository: TransactionRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionViewModel::class.java)) {
            val calculateTotalAmountUseCase = CalculateTotalAmountUseCaseImpl(repository)
            val calculateTotalIncomeUseCase = CalculateTotalIncomeUseCaseImpl(repository)
            val calculateTotalExpenseUseCase = CalculateTotalExpensesUseCaseImpl(repository)
            return TransactionViewModel(repository, calculateTotalAmountUseCase, calculateTotalIncomeUseCase, calculateTotalExpenseUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}