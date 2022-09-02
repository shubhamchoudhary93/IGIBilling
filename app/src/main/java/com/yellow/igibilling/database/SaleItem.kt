package com.yellow.igibilling.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sale_item_data_table")
data class SaleItem(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "sale_item_sale_id")
    var saleId: Long = 0L,

    @ColumnInfo(name = "sale_item_item")
    var item: String = "",

    @ColumnInfo(name = "sale_item_quantity")
    var quantity: Float = 0.0F,

    @ColumnInfo(name = "sale_item_rate")
    var rate: Float = 0.0F,

    @ColumnInfo(name = "sale_item_percentage")
    var percentage: Float = 0.0F,

    @ColumnInfo(name = "sale_item_calculated_rate")
    var calculatedRate: Float = 0.0F,

    @ColumnInfo(name = "sale_item_total")
    var total: Int = 0
)