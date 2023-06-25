package com.naveenkumawat.transactions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.text.DecimalFormat

class AccountingNumberTextWatcher(private val editText: EditText) : TextWatcher {

    private val decimalFormat: DecimalFormat = DecimalFormat("#,###.##")
    private var originalText: String = ""

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        originalText = s.toString()
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // No implementation needed
    }

    override fun afterTextChanged(s: Editable?) {
        val inputText = s.toString()

        // Remove the listener to prevent infinite recursion
        editText.removeTextChangedListener(this)

        // Remove any existing commas from the text
        val sanitizedText = inputText.replace(",", "")

        // Parse the sanitized text as a number
        val parsedNumber = try {
            sanitizedText.toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }

        // Format the parsed number with commas
        val formattedText = decimalFormat.format(parsedNumber)

        // Update the EditText text with the formatted text
        editText.setText(formattedText)
        editText.setSelection(formattedText.length)

        // Restore the listener
        editText.addTextChangedListener(this)
    }
}