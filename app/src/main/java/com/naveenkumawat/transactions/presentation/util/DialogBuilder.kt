package com.naveenkumawat.transactions.presentation.util

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import com.naveenkumawat.transactions.R

fun displayAlertPopup(it: FragmentActivity): AlertDialog? {
    val builder = AlertDialog.Builder(it)
    builder.setTitle(it.getString(R.string.out_of_bounds_dialog_title))
    builder.setMessage(it.getString(R.string.out_of_bounds_dialog_message, Double.MAX_VALUE))
    builder.setPositiveButton(it.getString(R.string.ok_text)) { dialog: DialogInterface, _: Int -> dialog.dismiss() }
    return builder.show()
}