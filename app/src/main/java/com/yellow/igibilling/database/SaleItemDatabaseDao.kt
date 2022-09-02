package com.yellow.igibilling.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SaleItemDatabaseDao {
    @Insert
    fun insert(saleDetails: SaleItem)

    @Update
    fun update(saleDetails: SaleItem)

    @Query("SELECT * from sale_item_data_table WHERE id = :id")
    fun get(id: Long): SaleItem?

    @Query("DELETE FROM sale_item_data_table")
    fun clear()

    @Query("DELETE FROM sale_item_data_table WHERE id = :id")
    fun delete(id: Long)

    @Query("SELECT * FROM sale_item_data_table ORDER BY id DESC")
    fun getAllSaleItem(): LiveData<List<SaleItem>>

    @Query("SELECT * FROM sale_item_data_table ORDER BY id DESC LIMIT 1")
    fun getLastSaleItem(): SaleItem

    @Query("SELECT sale_item_total FROM sale_item_data_table")
    fun getTotals(): List<Int>

    @Query("SELECT id FROM sale_item_data_table ORDER BY id DESC LIMIT 1")
    fun getLastSaleItemID(): Long

    @Query("UPDATE sale_item_data_table SET sale_item_sale_id = :saleId WHERE sale_item_sale_id =  :defaultId")
    fun updateSaleItemId(saleId: Long, defaultId: Long)

    @Query("SELECT * FROM sale_item_data_table WHERE sale_item_sale_id = :saleId ORDER BY id DESC")
    fun getSaleItem(saleId: Long): LiveData<List<SaleItem>>

    @Query("SELECT * FROM sale_item_data_table WHERE sale_item_sale_id = :saleId ORDER BY id DESC")
    fun getSaleItem1(saleId: Long): List<SaleItem>

    @Query("DELETE FROM sale_item_data_table WHERE sale_item_sale_id = :saleId")
    fun deleteSaleId(saleId: Long)
}