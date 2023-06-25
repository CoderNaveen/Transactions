package com.naveenkumawat.transactions


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

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
