package com.example.dimilkowska.android_cards.dao;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\'J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0012"}, d2 = {"Lcom/example/dimilkowska/android_cards/dao/TransactionDao;", "", "deleteTransaction", "", "transaction", "Lcom/example/dimilkowska/android_cards/entity/Transaction;", "deleteTransactionByCardId", "cardId", "", "getAllTransactions", "", "insertTransaction", "noAllTransactionsByDate", "", "from", "to", "sumAllTransactionsByDate", "updateTransaction", "app_debug"})
public abstract interface TransactionDao {
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract void insertTransaction(@org.jetbrains.annotations.NotNull()
    com.example.dimilkowska.android_cards.entity.Transaction transaction);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM cardTransaction WHERE id_card = :cardId")
    public abstract java.util.List<com.example.dimilkowska.android_cards.entity.Transaction> getAllTransactions(int cardId);
    
    @android.arch.persistence.room.Query(value = "SELECT count(*) FROM cardTransaction WHERE date_created BETWEEN :from AND :to AND id_card = :cardId")
    public abstract long noAllTransactionsByDate(long from, long to, int cardId);
    
    @android.arch.persistence.room.Query(value = "SELECT sum(amount) FROM cardTransaction WHERE date_created BETWEEN :from AND :to AND id_card = :cardId")
    public abstract long sumAllTransactionsByDate(long from, long to, int cardId);
    
    @android.arch.persistence.room.Delete()
    public abstract void deleteTransaction(@org.jetbrains.annotations.NotNull()
    com.example.dimilkowska.android_cards.entity.Transaction transaction);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM cardTransaction WHERE id_card = :cardId")
    public abstract void deleteTransactionByCardId(int cardId);
    
    @android.arch.persistence.room.Update()
    public abstract void updateTransaction(@org.jetbrains.annotations.NotNull()
    com.example.dimilkowska.android_cards.entity.Transaction transaction);
}