package com.naveenkumawat.transactions.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.naveenkumawat.transactions.data.repository.TransactionRepository
import com.naveenkumawat.transactions.domain.model.Transaction

class CalculateTotalAmountUseCaseImpl(private val transactionRepository: TransactionRepository):
    CalculateTotalAmountUseCase {
    override fun getTotalAmount(): LiveData<Double> {
        val totalAmountLiveData = MutableLiveData<Double>()

        val transactionsLiveData = transactionRepository.getAllTransactions()

        val totalAmountObserver = Observer<List<Transaction>> { transactions ->
            val totalAmount = transactions.sumOf { it.amount }
            totalAmountLiveData.value = totalAmount
        }

        transactionsLiveData.observeForever(totalAmountObserver)

        return totalAmountLiveData
    }
}