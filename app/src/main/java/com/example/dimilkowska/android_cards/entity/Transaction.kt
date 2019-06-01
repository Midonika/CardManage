package com.example.dimilkowska.android_cards.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import java.util.*

@Entity(tableName = "cardTransaction",
        indices = [Index("title"), Index("amount"), Index("account")],
        foreignKeys = [ForeignKey(entity = Card::class, parentColumns = ["id"], childColumns = ["id_card"])])
data class Transaction(
        @PrimaryKey(autoGenerate = true)
        val id: Int? = null,
        val title: String,
        val amount: Float,
        val account: String,
        val id_card: Int?,
        val date_created: Long)
