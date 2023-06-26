package com.naveenkumawat.transactions.domain.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.naveenkumawat.transactions.data.repository.TransactionRepository
import com.naveenkumawat.transactions.domain.model.Transaction
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
class CalculateTotalAmountUseCaseImplTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var transactionRepository: TransactionRepository

    private lateinit var calculateTotalAmountUseCase: CalculateTotalAmountUseCaseImpl

    @Before
    fun setup() {
        calculateTotalAmountUseCase = CalculateTotalAmountUseCaseImpl(transactionRepository)
    }

    @Test
    fun getTotalAmount_shouldReturnTotalAmount() {
        // Given
        val transactions = MockTransactionsGenerator.get()
        val liveData = MutableLiveData<List<Transaction>>()
        liveData.value = transactions
        `when`(transactionRepository.getAllTransactions()).thenReturn(liveData)
        val observer = mock<Observer<Double>>()
        calculateTotalAmountUseCase.getTotalAmount().observeForever(observer)

        // When
        verify(transactionRepository).getAllTransactions()
        val captor = argumentCaptor<Double>()
        verify(observer).onChanged(captor.capture())
        val capturedValue = captor.firstValue

        // Then
        val expectedTotalAmount = transactions.sumOf { it.amount }
        assertEquals(expectedTotalAmount, capturedValue, 0.0)
    }
}