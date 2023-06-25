package com.naveenkumawat.transactions.presentation

import com.naveenkumawat.transactions.domain.model.Transaction


fun interface AddButtonListener {
    fun onAddButtonClicked(transaction: Transaction)
}