package com.naveenkumawat.transactions

import androidx.lifecycle.LiveData
import androidx.lifecycle.map

class TransactionRepositoryImpl(private val transactionDao: TransactionDao) : TransactionRepository {
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
            transactions.filter { it.type == TransactionType.INCOME  }
        }
    }

    override fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }

    override fun deleteTransaction(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction)
    }
}