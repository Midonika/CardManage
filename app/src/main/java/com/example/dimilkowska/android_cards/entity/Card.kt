package com.example.dimilkowska.android_cards.entity

import android.arch.persistence.room.*
import android.support.annotation.NonNull

@Entity
data class Card(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        var id: Int? = null,
        val name: String,
        val account: String,
        val period: Int,
        val limit_total: Double,
        val limit_count: Double,
        val free_100: Boolean)