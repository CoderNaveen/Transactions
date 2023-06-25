package com.naveenkumawat.transactions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class CalculateTotalIncomeUseCaseImpl(private val transactionRepository: TransactionRepository): CalculateTotalIncomeUseCase {
    override fun getIncomeTotal(): LiveData<Double> {
        val totalIncomeLiveData = MutableLiveData<Double>()

        val incomeTransactionsLiveData = transactionRepository.getIncomeTransactions()

        val totalIncomeObserver = Observer<List<Transaction>> { transactions ->
            val totalIncome = transactions.sumOf { it.amount }
            totalIncomeLiveData.value = totalIncome
        }

        incomeTransactionsLiveData.observeForever(totalIncomeObserver)

        return totalIncomeLiveData
    }
}