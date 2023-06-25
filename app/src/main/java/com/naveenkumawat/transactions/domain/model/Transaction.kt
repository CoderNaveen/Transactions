package com.naveenkumawat.transactions.domain.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.naveenkumawat.transactions.data.local.Converters

@Entity(tableName = "transactions")
@TypeConverters(Converters::class)
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val description: String,
    val amount: Double,
    val date: Long,
    val type: TransactionType
)

enum class TransactionType {
    INCOME,
    EXPENSE
}
