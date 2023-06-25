package com.naveenkumawat.transactions

import android.text.method.NumberKeyListener

class AccountingNumberKeyListener : NumberKeyListener() {

    companion object {
        private val CHARS_ACCEPTED = charArrayOf(
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',', '.'
        )
    }

    override fun getAcceptedChars(): CharArray {
        return CHARS_ACCEPTED
    }

    override fun getInputType(): Int {
        return android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
    }
}