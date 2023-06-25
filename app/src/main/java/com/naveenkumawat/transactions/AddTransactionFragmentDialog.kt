package com.naveenkumawat.transactions

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import com.naveenkumawat.transactions.databinding.DialogAddTransactionBinding

class AddTransactionFragmentDialog(private val addButtonListener: AddButtonListener) :
    DialogFragment() {
    private val viewModelAmountET: AmountEditTextViewModel by viewModels()
    private lateinit var binding: DialogAddTransactionBinding
    private lateinit var spinnerTransactionType: Spinner
    private lateinit var editTextDescription: EditText
    private lateinit var editTextDollarAmount: EditText
    private lateinit var buttonIncrement: ImageButton
    private lateinit var buttonDecrement: ImageButton
    private lateinit var buttonAdd: Button
    private lateinit var buttonCancel: Button

    companion object {
        const val TAG = "AddTransactionFragmentDialog"
    }

    override fun onStart() {
        super.onStart()

        // Screen dimensions
        val displayMetrics = resources.displayMetrics
        val screenWidth = displayMetrics.widthPixels
//        val screenHeight = displayMetrics.heightPixels

        // Desired height and width as a percentage of the screen dimensions
//        val desiredHeight = (screenHeight * 0.6).toInt()
//        val desiredWidth = (screenWidth * 0.9).toInt()

        // Size of the dialog window
        dialog?.window?.apply {
            setLayout(screenWidth, WindowManager.LayoutParams.WRAP_CONTENT)
            setGravity(Gravity.CENTER)
            // Additional configuration options for the dialog window
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogAddTransactionBinding.inflate(layoutInflater)
        initComponents()
        return binding.root
    }

    private fun initComponents() {
        setViewBindings()
        setSpinnerContent()
        setAddButtonOnClickListener()
        setCancelButtonOnClickListener()
    }

    private fun setViewBindings() {
        binding.apply {
            spinnerTransactionType = spTransactionType
            editTextDescription = etTransactionDescription
            editTextDollarAmount = clDollarContainer.etDollarAmount
            editTextDollarAmount.keyListener = AccountingNumberKeyListener()
            editTextDollarAmount.addTextChangedListener(
                AccountingNumberTextWatcher(
                    editTextDollarAmount
                )
            )
            editTextDollarAmount.setOnEditorActionListener { _, i, _ ->
                handleOnEnterClicked(i)
            }
            setIncrementButton(this)
            setDecrementButton(this)
            buttonAdd = btnAdd
            buttonCancel = btnCancel
        }
    }

    private fun handleOnEnterClicked(i: Int) = if (i == EditorInfo.IME_ACTION_DONE) {
        onAddButtonClicked()
        true
    } else {
        false
    }

    private fun setIncrementButton(binding: DialogAddTransactionBinding) {
        buttonIncrement = binding.clDollarContainer.btnUp
        buttonIncrement.setOnClickListener {
            editTextDollarAmount.setText(
                viewModelAmountET.updateEditTextValue(
                    editTextDollarAmount.text.toString(),
                    true
                )
            )
        }
    }

    private fun setDecrementButton(binding: DialogAddTransactionBinding) {
        buttonDecrement = binding.clDollarContainer.btnDown
        buttonDecrement.setOnClickListener {
            editTextDollarAmount.setText(viewModelAmountET.updateEditTextValue(editTextDollarAmount.text.toString()))
        }
    }

    private fun setSpinnerContent() {
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.transaction_type_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerTransactionType.adapter = adapter
            }
        }
    }

    private fun setCancelButtonOnClickListener() {
        buttonCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun setAddButtonOnClickListener() {
        buttonAdd.setOnClickListener {
            onAddButtonClicked()
        }
    }

    private fun onAddButtonClicked() {
        if (viewModelAmountET.checkIfTextsAreEmptyOrZero(
                editTextDescription.text.toString(),
                editTextDollarAmount.text.toString()
            )
        ) {
            Toast.makeText(context, R.string.fill_in_the_blanks, Toast.LENGTH_SHORT)
                .show()
        } else {
            activity?.let {
                getTransactionType(spinnerTransactionType.selectedItem.toString())?.let { transactionType ->
                    makeTransaction(transactionType, it)
                }
            }
        }
    }

    private fun getTransactionType(textValue: String): TransactionType? {
        return when {
            (textValue.equals(TransactionType.INCOME.name, true)) -> TransactionType.INCOME
            (textValue.equals(TransactionType.EXPENSE.name, true)) -> TransactionType.EXPENSE
            else -> null
        }
    }

    private fun makeTransaction(
        transactionType: TransactionType,
        it: FragmentActivity
    ) = try {
        val description = editTextDescription.text.toString()
        val amountString = editTextDollarAmount.text.toString()
        val sanitizedAmount = amountString.replace(",", "")
        val amountDouble = sanitizedAmount.toDouble()
        val amount = when (transactionType) {
            TransactionType.EXPENSE -> (amountDouble * -1)
            TransactionType.INCOME -> amountDouble
        }
        val date = System.currentTimeMillis()

        val transaction = Transaction(
            description = description,
            amount = amount,
            date = date,
            type = transactionType
        )
        addButtonListener.onAddButtonClicked(transaction)
        dismiss()
    } catch (e: NumberFormatException) {
        displayAlertPopup(it)
    }
}