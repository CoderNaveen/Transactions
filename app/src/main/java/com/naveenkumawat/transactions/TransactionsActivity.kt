package com.naveenkumawat.transactions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.naveenkumawat.transactions.data.local.TransactionDatabase
import com.naveenkumawat.transactions.data.repository.TransactionRepositoryImpl
import com.naveenkumawat.transactions.databinding.ActivityTransactionsBinding
import com.naveenkumawat.transactions.domain.model.Transaction
import com.naveenkumawat.transactions.presentation.AddButtonListener
import com.naveenkumawat.transactions.presentation.adapter.TransactionAdapter
import com.naveenkumawat.transactions.presentation.dialog.AddTransactionFragmentDialog
import com.naveenkumawat.transactions.presentation.viewmodel.TransactionViewModel
import com.naveenkumawat.transactions.presentation.viewmodel.TransactionViewModelFactory

class TransactionsActivity : AppCompatActivity(), AddButtonListener {

    private lateinit var binding: ActivityTransactionsBinding

    private lateinit var tvExpensesHeading: TextView
    private lateinit var tvExpensesLabel: TextView
    private lateinit var tvIncomeHeading: TextView
    private lateinit var tvIncomeLabel: TextView
    private lateinit var tvBalanceHeading: TextView
    private lateinit var tvBalanceLabel: TextView
    private lateinit var rvTransactions: RecyclerView
    private lateinit var fabAddButton: FloatingActionButton
    private lateinit var lpiBalanceBar: LinearProgressIndicator

    private lateinit var viewModel: TransactionViewModel
    private lateinit var adapter: TransactionAdapter

    companion object {
        const val TAG = "TransactionsActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transactions)

        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transactionDao = TransactionDatabase.getInstance(this).transactionDao()
        val repository = TransactionRepositoryImpl(transactionDao)

        // Pass the repository instance to the ViewModel constructor
        viewModel = ViewModelProvider(this, TransactionViewModelFactory(repository))[TransactionViewModel::class.java]

        initComponents()
    }

    private fun initComponents() {
        setViewBindings()
        setBalanceContainerHeadings()
        setBalanceContainerValues()
        setRecyclerViewList()
    }

    private fun setBalanceContainerHeadings() {
        tvExpensesHeading.text = getString(R.string.expense_text_heading)
        tvIncomeHeading.text = getString(R.string.income_text_heading)
        tvBalanceHeading.text = getString(R.string.balance_text_heading)
    }

    private fun setBalanceContainerValues() {
        viewModel.totalAmount.observe(this) { totalAmount ->
            tvBalanceLabel.text = totalAmount.toString()
        }

        viewModel.totalIncome.observe(this) { totalIncome ->
            tvIncomeLabel.text = totalIncome.toString()
            lpiBalanceBar.max = when (totalIncome == 0.0 || totalIncome < 0) {
                true -> 1
                else -> totalIncome.toInt()
            }
        }

        viewModel.totalExpense.observe(this) { totalExpense ->
            tvExpensesLabel.text = totalExpense.toString()
            lpiBalanceBar.progress = (totalExpense.toInt() * -1)
        }
    }

    private fun setViewBindings() {
        binding.apply {
            tvExpensesHeading = clBalanceContainer.clExpenses.tvHeading
            tvExpensesLabel = clBalanceContainer.clExpenses.tvLabel
            tvIncomeHeading = clBalanceContainer.clIncome.tvHeading
            tvIncomeLabel = clBalanceContainer.clIncome.tvLabel
            tvBalanceHeading = clBalanceContainer.clBalance.tvHeading
            tvBalanceLabel = clBalanceContainer.clBalance.tvLabel
            lpiBalanceBar = clBalanceContainer.lpiBalanceIndicator
            rvTransactions = rvTransactionsContainer
            setFloatingActionButton(this)
        }
    }

    private fun setFloatingActionButton(binding: ActivityTransactionsBinding) {
        fabAddButton = binding.fabButton
        fabAddButton.setOnClickListener {
            openDialog()
        }
    }

    private fun openDialog() {
        val dialog = AddTransactionFragmentDialog(this)
        dialog.show(supportFragmentManager, AddTransactionFragmentDialog.TAG)
    }

    private fun setRecyclerViewList() {
        adapter = TransactionAdapter(this, ::deleteTransaction)

        binding.rvTransactionsContainer.adapter = adapter
        binding.rvTransactionsContainer.layoutManager = LinearLayoutManager(this)

        viewModel.transactions.observe(this) { transactions ->
            adapter.setTransactions(transactions)
        }

        val itemTouchHelper = ItemTouchHelper(adapter.getSwipeCallback())
        itemTouchHelper.attachToRecyclerView(binding.rvTransactionsContainer)
    }

    private fun deleteTransaction(transaction: Transaction) {
        viewModel.deleteTransaction(transaction)
    }

    override fun onAddButtonClicked(transaction: Transaction) {
        // Insert the new transaction using the repository
        viewModel.insertTransaction(transaction)
    }
}