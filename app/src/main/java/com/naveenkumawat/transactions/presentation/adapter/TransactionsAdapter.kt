package com.naveenkumawat.transactions.presentation.adapter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.naveenkumawat.transactions.databinding.ItemEmptyBinding
import com.naveenkumawat.transactions.databinding.ItemHeaderTransactionsBinding
import com.naveenkumawat.transactions.databinding.ItemTransactionDataBinding
import com.naveenkumawat.transactions.domain.model.Transaction
import com.naveenkumawat.transactions.util.formatDate


class TransactionAdapter(private val context: Context,  private val onDeleteTransaction: (Transaction) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_TRANSACTION = 1
        private const val VIEW_TYPE_EMPTY = -1
    }

    private var transactions: List<Transaction> = emptyList()
/*private var transactions: List<Transaction> = listOf(
    Transaction(0, "Expense 2", -20.00, 1674700800000, TransactionType.EXPENSE),
    Transaction(1, "Income 1", 50.00, 1674768000000, TransactionType.INCOME),
    Transaction(2, "Expense 1", -10.00, 1674700800000, TransactionType.EXPENSE),
    Transaction(3, "Expense 3", -15.00, 1674768000000, TransactionType.EXPENSE),
    Transaction(4, "Income 2", 30.00, 1674768000000, TransactionType.INCOME)
)*/
    // Group transactions by date
    private var transactionsByDate: HashMap<String, List<Transaction>> = HashMap()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val binding = ItemHeaderTransactionsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HeaderViewHolder(binding).apply {
                    // Disable click and long click listeners for header view holder
                    itemView.isClickable = false
                    itemView.isLongClickable = false
                }
            }
            VIEW_TYPE_TRANSACTION -> {
                val binding = ItemTransactionDataBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                TransactionViewHolder(binding)
            }
            VIEW_TYPE_EMPTY -> {
                val binding = ItemEmptyBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                EmptyViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val iterator = transactionsByDate.iterator()
        var count = 0
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (count == position) {
                if (holder is HeaderViewHolder) {
                    holder.bind(entry.key)
                }
                break
            }
            count++
            if (position < count + entry.value.size) {
                if (holder is TransactionViewHolder) {
                    val transaction = entry.value[position - count]
                    holder.bind(transaction)
                }
                break
            }
            count += entry.value.size
        }
    }

    override fun getItemCount(): Int {
        var count = 0
        for (entry in transactionsByDate.entries) {
            count += entry.value.size + 1 // Include the header count
        }

        return when(count) {
            0 -> { 1 }
            else -> { count }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(transactions.isEmpty()) return VIEW_TYPE_EMPTY
        val iterator = transactionsByDate.iterator()
        var count = 0
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (count == position) {
                return VIEW_TYPE_HEADER
            }
            count++
            if (position < count + entry.value.size) {
                return VIEW_TYPE_TRANSACTION
            }
            count += entry.value.size
        }
        throw IllegalArgumentException("Invalid position")
    }

    fun setTransactions(transactions: List<Transaction>) {
        this.transactions = transactions
        // Group transactions by date
        this.transactionsByDate = transactions.groupBy { formatDate(it.date) } as HashMap<String, List<Transaction>>

        notifyDataSetChanged()
    }

    inner class HeaderViewHolder(private val binding: ItemHeaderTransactionsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(date: String) {
            binding.tvRowDate.text = date
        }
    }

    inner class TransactionViewHolder(private val binding: ItemTransactionDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
            val transactionTitle = transaction.description
            binding.tvTransactionLabel.text = transactionTitle

            val transactionAmount = transaction.amount
            binding.tvTransactionAmount.text = transactionAmount.toString()
        }
    }

    inner class EmptyViewHolder(private val binding: ItemEmptyBinding) : RecyclerView.ViewHolder(binding.root)

    fun getSwipeCallback(): ItemTouchHelper.SimpleCallback {
        return object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            private val background: Drawable = ColorDrawable(Color.RED)
            private val deleteIcon: Drawable? = ContextCompat.getDrawable(
                context,
                android.R.drawable.ic_menu_delete
            )

            override fun getSwipeDirs (recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
                return if (viewHolder is HeaderViewHolder) {
                    0
                }else {
                    super.getSwipeDirs(recyclerView, viewHolder)
                }
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (viewHolder is TransactionViewHolder) {
                    val iterator = transactionsByDate.iterator()
                    var count = 0
                    while (iterator.hasNext()) {
                        val entry = iterator.next()
                        if (position < count + entry.value.size + 1) { // Add 1 to account for the header item
                            val transactionToDelete = entry.value[position - count - 1] // Subtract 1 to get the correct transaction index
                            onDeleteTransaction(transactionToDelete)
                            break
                        }
                        count += entry.value.size + 1
                    }
                } else {
                    notifyItemChanged(viewHolder.adapterPosition)
                }
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

                val itemView = viewHolder.itemView
                var iconMargin: Int = 150
                var iconTop: Int = 150
                var iconBottom: Int = 150
                deleteIcon?.intrinsicHeight?.let {
                    iconMargin = (itemView.height - it) / 2
                    iconTop = itemView.top + (itemView.height - it) / 2
                    iconBottom = iconTop + it
                }
                if (dX > 0) {
                    val iconLeft = itemView.left + iconMargin
                    val iconRight = itemView.left + iconMargin + (deleteIcon?.intrinsicWidth ?: 4)
                    deleteIcon?.setBounds(iconLeft, iconTop, iconRight, iconBottom)
                    background.setBounds(
                        itemView.left, itemView.top,
                        itemView.left + dX.toInt(), itemView.bottom
                    )
                } else {
                    val iconLeft = itemView.right - iconMargin - (deleteIcon?.intrinsicWidth ?: 4)
                    val iconRight = itemView.right - iconMargin
                    deleteIcon?.setBounds(iconLeft, iconTop, iconRight, iconBottom)
                    background.setBounds(
                        itemView.right + dX.toInt(), itemView.top,
                        itemView.right, itemView.bottom
                    )
                }

                background.draw(c)
                deleteIcon?.draw(c)
            }
        }
    }
}