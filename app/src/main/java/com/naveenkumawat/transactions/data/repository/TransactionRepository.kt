package com.naveenkumawat.transactions.data.repository

import androidx.lifecycle.LiveData
import com.naveenkumawat.transactions.domain.model.Transaction

interface TransactionRepository {
    fun getAllTransactions(): LiveData<List<Transaction>>
    fun getExpenseTransactions(): LiveData<List<Transaction>>
    fun getIncomeTransactions(): LiveData<List<Transaction>>
    fun insertTransaction(transaction: Transaction)
    fun deleteTransaction(transaction: Transaction)
}