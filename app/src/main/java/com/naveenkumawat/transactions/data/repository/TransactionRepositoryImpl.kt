package com.naveenkumawat.transactions.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.naveenkumawat.transactions.domain.model.Transaction
import com.naveenkumawat.transactions.domain.model.TransactionType
import com.naveenkumawat.transactions.data.local.TransactionDao

class TransactionRepositoryImpl(private val transactionDao: TransactionDao) :
    TransactionRepository {
    override fun getAllTransactions(): LiveData<List<Transaction>> {
        return transactionDao.getAllTransactions()
    }

    override fun getExpenseTransactions(): LiveData<List<Transaction>> {
        return transactionDao.getAllTransactions().map { transactions ->
            transactions.filter { it.type == TransactionType.EXPENSE }
        }
    }

    override fun getIncomeTransactions(): LiveData<List<Transaction>> {
        return transactionDao.getAllTransactions().map { transactions ->
            transactions.filter { it.type == TransactionType.INCOME }
        }
    }

    override fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }

    override fun deleteTransaction(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction)
    }
}