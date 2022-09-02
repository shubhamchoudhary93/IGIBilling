package com.yellow.igibilling.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "sale_data_table")
data class Sale(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "sale_cash")
    var cash: Boolean = false,

    @ColumnInfo(name = "sale_date")
    var date: String = "1/4/2021",

    @ColumnInfo(name = "sale_customer")
    var name: String = "",

    @ColumnInfo(name = "sale_tax")
    var tax: Float = 0.0F,

    @ColumnInfo(name = "sale_transport")
    var transport: Float = 0.0F,

    @ColumnInfo(name = "sale_other_charges_name")
    var otherChargesName: String = "",

    @ColumnInfo(name = "sale_other_charges_value")
    var otherChargesValue: Float = 0.0F,

    @ColumnInfo(name = "sale_amount")
    var amount: Int = 0
)