package com.naveenkumawat.transactions.data.local.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.naveenkumawat.transactions.data.local.TransactionDao
import com.naveenkumawat.transactions.data.repository.TransactionRepositoryImpl
import com.naveenkumawat.transactions.domain.model.Transaction
import com.naveenkumawat.transactions.domain.model.TransactionType
import com.naveenkumawat.transactions.util.MockTransactionsGenerator
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TransactionRepositoryImplTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var transactionDao: TransactionDao

    private lateinit var transactionRepository: TransactionRepositoryImpl

    @Before
    fun setup() {
        transactionRepository = TransactionRepositoryImpl(transactionDao)
    }

    @Test
    fun getAllTransactions_shouldReturnAllTransactions() {
        // Given
        val transactions = MockTransactionsGenerator.get()
        val liveData = MutableLiveData<List<Transaction>>()
        liveData.value = transactions
        `when`(transactionDao.getAllTransactions()).thenReturn(liveData)
        val observer = mock<Observer<List<Transaction>>>()
        transactionRepository.getAllTransactions().observeForever(observer)

        // When
        verify(transactionDao).getAllTransactions()
        val captor = argumentCaptor<List<Transaction>>()
        verify(observer).onChanged(captor.capture())
        val capturedValue = captor.firstValue

        // Then
        assertEquals(transactions, capturedValue)
    }

    @Test
    fun getExpenseTransactions_shouldReturnExpenseTransactions() {
        // Given
        val transactions = MockTransactionsGenerator.get()
        val liveData = MutableLiveData<List<Transaction>>()
        liveData.value = transactions
        `when`(transactionDao.getAllTransactions()).thenReturn(liveData)
        val observer = mock<Observer<List<Transaction>>>()
        transactionRepository.getExpenseTransactions().observeForever(observer)

        // When
        verify(transactionDao).getAllTransactions()
        val captor = argumentCaptor<List<Transaction>>()
        verify(observer).onChanged(captor.capture())
        val capturedValue = captor.firstValue
        val expectedExpenseTransactions = transactions.filter { it.type == TransactionType.EXPENSE }

        // Then
        assertEquals(expectedExpenseTransactions, capturedValue)
    }

    @Test
    fun getIncomeTransactions_shouldReturnIncomeTransactions() {
        // Given
        val transactions = MockTransactionsGenerator.get()
        val liveData = MutableLiveData<List<Transaction>>()
        liveData.value = transactions
        `when`(transactionDao.getAllTransactions()).thenReturn(liveData)
        val observer = mock<Observer<List<Transaction>>>()
        transactionRepository.getIncomeTransactions().observeForever(observer)

        // When
        verify(transactionDao).getAllTransactions()
        val captor = argumentCaptor<List<Transaction>>()
        verify(observer).onChanged(captor.capture())
        val capturedValue = captor.firstValue
        val expectedIncomeTransactions = transactions.filter { it.type == TransactionType.INCOME }

        // Then
        assertEquals(expectedIncomeTransactions, capturedValue)
    }

    @Test
    fun insertTransaction_shouldInsertTransaction() {
        // Given
        val transaction = MockTransactionsGenerator.get().random()

        // When
        transactionRepository.insertTransaction(transaction)

        // Then
        verify(transactionDao).insertTransaction(transaction)
    }

    @Test
    fun deleteTransaction_shouldDeleteTransaction() {
        // Given
        val transaction = MockTransactionsGenerator.get().random()

        // When
        transactionRepository.deleteTransaction(transaction)

        // Then
        verify(transactionDao).deleteTransaction(transaction)
    }
}