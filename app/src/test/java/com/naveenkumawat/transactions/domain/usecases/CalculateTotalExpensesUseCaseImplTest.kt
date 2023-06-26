package com.naveenkumawat.transactions.domain.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.naveenkumawat.transactions.data.repository.TransactionRepository
import com.naveenkumawat.transactions.domain.model.Transaction
import com.naveenkumawat.transactions.domain.model.TransactionType
import com.naveenkumawat.transactions.util.MockTransactionsGenerator
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculateTotalExpensesUseCaseImplTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var transactionRepository: TransactionRepository

    private lateinit var calculateTotalExpensesUseCase: CalculateTotalExpensesUseCaseImpl

    @Before
    fun setup() {
        calculateTotalExpensesUseCase = CalculateTotalExpensesUseCaseImpl(transactionRepository)
    }

    @Test
    fun getExpenseTotal_shouldReturnTotalExpense() {
        // Given
        val transactions = MockTransactionsGenerator.get()
        val expenseTransactions = transactions.filter { it.type == TransactionType.EXPENSE }
        val liveData = MutableLiveData<List<Transaction>>()
        liveData.value = expenseTransactions
        `when`(transactionRepository.getExpenseTransactions()).thenReturn(liveData)
        val observer = mock<Observer<Double>>()
        calculateTotalExpensesUseCase.getExpenseTotal().observeForever(observer)

        // When
        verify(transactionRepository).getExpenseTransactions()
        val captor = argumentCaptor<Double>()
        verify(observer).onChanged(captor.capture())
        val capturedValue = captor.firstValue

        // Then
        val expectedTotalExpense = expenseTransactions.sumOf { it.amount }
        assertEquals(expectedTotalExpense, capturedValue, 0.0)
    }
}