package com.jachai.walleto_expensemanager.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jachai.walleto_expensemanager.data.model.Transaction

@Database(
    entities = [Transaction::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun getTransactionDao(): TransactionDao
}
