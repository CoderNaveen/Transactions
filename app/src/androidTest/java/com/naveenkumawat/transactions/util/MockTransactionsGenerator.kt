package com.naveenkumawat.transactions.util

import com.naveenkumawat.transactions.domain.model.Transaction
import com.naveenkumawat.transactions.domain.model.TransactionType

class MockTransactionsGenerator {
    companion object {
        fun get(): List<Transaction> {
            return listOf(
                Transaction(1, "Food", 100.0, 1687731217000, TransactionType.EXPENSE),
                Transaction(2, "Salary", 5000.0, 1687731218000, TransactionType.INCOME),
                Transaction(2, "Electricity", 1500.0, 1687731218000, TransactionType.EXPENSE),
                Transaction(2, "Stock", 2500.0, 1687731218000, TransactionType.INCOME),
                Transaction(2, "Shopping", 500.0, 1687731218000, TransactionType.EXPENSE),
                Transaction(3, "Rent", 500.0, 1687731219000, TransactionType.INCOME)
            )
        }
    }
}