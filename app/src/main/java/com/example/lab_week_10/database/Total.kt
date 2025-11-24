package com.example.lab_week_10.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "total_table")
data class Total(
    @PrimaryKey val id: Int = 1,
    val total: Int,
    val timestamp: String
)
