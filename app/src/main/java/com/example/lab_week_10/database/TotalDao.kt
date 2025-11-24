package com.example.lab_week_10.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TotalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(total: Total)

    @Query("SELECT * FROM total_table WHERE id = 1")
    suspend fun getTotal(): Total?
}
