package com.jachai.walleto_expensemanager.exportcsv

import com.jachai.walleto_expensemanager.data.model.Transaction
import com.opencsv.bean.CsvBindByName

data class TransactionsCSV(
    @CsvBindByName(column = "title")
    val title: String,
    @CsvBindByName(column = "amount")
    val amount: Double,
    @CsvBindByName(column = "transactionType")
    val transactionType: String,
    @CsvBindByName(column = "tag")
    val tag: String,
    @CsvBindByName(column = "date")
    val date: String,
    @CsvBindByName(column = "note")
    val note: String,
    @CsvBindByName(column = "createdAt")
    val createdAtDate: String
)

fun List<Transaction>.toCsv() = map {
    TransactionsCSV(
        title = it.title,
        amount = it.amount,
        transactionType = it.transactionType,
        tag = it.tag,
        date = it.date,
        note = it.note,
        createdAtDate = it.createdAtDateFormat,
    )
}
