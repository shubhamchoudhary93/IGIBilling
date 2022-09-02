package com.yellow.igibilling.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SaleItem::class], version = 1, exportSchema = false)
abstract class SaleItemDatabase : RoomDatabase() {

    abstract val saleDetailsDatabaseDao: SaleItemDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: SaleItemDatabase? = null

        fun getInstance(context: Context): SaleItemDatabase {
            synchronized(this) {

                var instance =
                    INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SaleItemDatabase::class.java,
                        "sale_item_data_table"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}