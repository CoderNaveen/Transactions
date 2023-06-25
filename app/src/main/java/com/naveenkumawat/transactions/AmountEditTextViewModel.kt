package com.naveenkumawat.transactions

import androidx.lifecycle.ViewModel

class AmountEditTextViewModel : ViewModel() {
    companion object {
        private const val ZERO_TEXT = "0"
    }

    fun updateEditTextValue(textValue: String?, isIncrement: Boolean = false): String {
        return if (!textValue.isNullOrEmpty()) {
            var tempInt = Integer.parseInt(textValue)
            when (isIncrement) {
                true -> tempInt++
                else -> {
                    if (tempInt > 0) {
                        tempInt--
                    }
                }
            }
            tempInt.toString()
        } else {
            ZERO_TEXT
        }
    }

    fun checkIfTextsAreEmptyOrZero(
        editTextDescription: String?,
        editTextDollarAmount: String?
    ): Boolean =
        editTextDescription.isNullOrEmpty() || editTextDollarAmount.isNullOrEmpty() || editTextDollarAmount == ZERO_TEXT
}