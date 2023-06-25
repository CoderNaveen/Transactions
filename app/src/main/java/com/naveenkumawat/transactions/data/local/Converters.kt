package com.naveenkumawat.transactions.data.local

import androidx.room.TypeConverter
import com.naveenkumawat.transactions.domain.model.TransactionType

class Converters {
    @TypeConverter
    fun fromTransactionType(value: TransactionType): String {
        return value.name
    }

    @TypeConverter
    fun toTransactionType(value: String): TransactionType {
        return enumValueOf(value)
    }
}