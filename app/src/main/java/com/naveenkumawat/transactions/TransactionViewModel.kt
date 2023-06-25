package com.naveenkumawat.transactions

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransactionViewModel(private val repository: TransactionRepository,
                           calculateTotalAmountUseCase: CalculateTotalAmountUseCase,
                           calculateTotalIncomeUseCase: CalculateTotalIncomeUseCase,
                           calculateTotalExpensesUseCase: CalculateTotalExpensesUseCase) : ViewModel() {
    val transactions: LiveData<List<Transaction>> = repository.getAllTransactions()
    val totalAmount: LiveData<Double> = calculateTotalAmountUseCase.getTotalAmount()
    val totalIncome: LiveData<Double> = calculateTotalIncomeUseCase.getIncomeTotal()
    val totalExpense: LiveData<Double> = calculateTotalExpensesUseCase.getExpenseTotal()
    fun insertTransaction(transaction: Transaction) {
        viewModelScope.launch(viewModelScope.coroutineContext + Dispatchers.IO) {
            repository.insertTransaction(transaction)
        }
    }

    fun deleteTransaction(transaction: Transaction) {
        viewModelScope.launch(viewModelScope.coroutineContext + Dispatchers.IO) {
            repository.deleteTransaction(transaction)
        }
    }

}