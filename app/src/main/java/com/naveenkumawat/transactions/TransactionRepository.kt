package com.naveenkumawat.transactions

import androidx.lifecycle.LiveData

interface TransactionRepository {
    fun getAllTransactions(): LiveData<List<Transaction>>
    fun getExpenseTransactions(): LiveData<List<Transaction>>
    fun getIncomeTransactions(): LiveData<List<Transaction>>
    fun insertTransaction(transaction: Transaction)
    fun deleteTransaction(transaction: Transaction)
}