package com.example.dimilkowska.android_cards.dao

import android.arch.persistence.room.*
import com.example.dimilkowska.android_cards.entity.Card

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card: Card): Long

    @Update
    fun updateCard(card: Card)

    @Delete
    fun deleteCard(card: Card)

    @Query("SELECT * FROM card WHERE name == :name")
    fun getCardByName(name: String): List<Card>

    @Query("SELECT * FROM card")
    fun getCards(): List<Card>

}