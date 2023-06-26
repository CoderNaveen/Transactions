package com.naveenkumawat.transactions.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.naveenkumawat.transactions.domain.model.Transaction
import com.naveenkumawat.transactions.domain.model.TransactionType
import com.naveenkumawat.transactions.util.MockTransactionsGenerator
import com.naveenkumawat.transactions.util.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TransactionDaoTest {

    private lateinit var transactionDao: TransactionDao
    private lateinit var db: TransactionDatabase

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, TransactionDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        transactionDao = db.transactionDao()
    }

    @After
    @Throws(IOException::class)
    fun cleanup() {
        db.clearAllTables()
        db.close()
    }

    @Test
    fun testInsertAndRetrieveTransactions() = runBlocking {
        // Delete existing transactions before the test
        val existingTransactions = transactionDao.getAllTransactions().getOrAwaitValue()
        for (transaction in existingTransactions) {
            transactionDao.deleteTransaction(transaction)
        }

        val transactionToInsert = MockTransactionsGenerator.get().random()
        transactionDao.insertTransaction(transactionToInsert)

        // Retrieve the inserted transaction from the database
        val retrievedTransaction = transactionDao.getAllTransactions().getOrAwaitValue()[0]

        assertEquals(transactionToInsert, retrievedTransaction)
    }

    @Test
    fun testDeleteTransaction() = runBlocking {
        // Create a test transaction
        val transaction = MockTransactionsGenerator.get().random()

        // Insert the transaction into the database
        transactionDao.insertTransaction(transaction)

        // Delete the transaction from the database
        transactionDao.deleteTransaction(transaction)

        // Retrieve all transactions from the database
        val allTransactions = transactionDao.getAllTransactions().getOrAwaitValue()

        // Verify that the transaction is deleted
        assertEquals(0, allTransactions.size)
    }
}