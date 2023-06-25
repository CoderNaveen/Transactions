package com.naveenkumawat.transactions.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.naveenkumawat.transactions.data.repository.TransactionRepository
import com.naveenkumawat.transactions.domain.model.Transaction

class CalculateTotalExpensesUseCaseImpl(private val transactionRepository: TransactionRepository):
    CalculateTotalExpensesUseCase {
    override fun getExpenseTotal(): LiveData<Double> {
            val totalExpenseLiveData = MutableLiveData<Double>()

            val expenseTransactionsLiveData = transactionRepository.getExpenseTransactions()

            val totalExpenseObserver = Observer<List<Transaction>> { transactions ->
                val totalExpense = transactions.sumOf { it.amount }
                totalExpenseLiveData.value = totalExpense
            }

            expenseTransactionsLiveData.observeForever(totalExpenseObserver)

            return totalExpenseLiveData
    }
}