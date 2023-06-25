package com.naveenkumawat.transactions.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naveenkumawat.transactions.data.repository.TransactionRepository
import com.naveenkumawat.transactions.domain.usecases.CalculateTotalAmountUseCaseImpl
import com.naveenkumawat.transactions.domain.usecases.CalculateTotalExpensesUseCaseImpl
import com.naveenkumawat.transactions.domain.usecases.CalculateTotalIncomeUseCaseImpl


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