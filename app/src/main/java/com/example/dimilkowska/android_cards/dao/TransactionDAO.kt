package com.example.dimilkowska.android_cards.dao

import android.arch.persistence.room.*
import com.example.dimilkowska.android_cards.entity.Transaction
import java.util.*

@Dao
interface TransactionDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM cardTransaction WHERE id_card = :cardId")
    fun getAllTransactions(cardId: Int): List<Transaction>

    @Query("SELECT count(*) FROM cardTransaction WHERE date_created BETWEEN :from AND :to AND id_card = :cardId")
    fun noAllTransactionsByDate(from: Long, to: Long, cardId: Int): Long

    @Query("SELECT sum(amount) FROM cardTransaction WHERE date_created BETWEEN :from AND :to AND id_card = :cardId")
    fun sumAllTransactionsByDate(from: Long, to: Long, cardId: Int): Long

    @Delete
    fun deleteTransaction(transaction: Transaction)

    @Query("DELETE FROM cardTransaction WHERE id_card = :cardId")
    fun deleteTransactionByCardId(cardId: Int)

    @Update
    fun updateTransaction(transaction: Transaction)
}