package com.example.dimilkowska.android_cards.dao;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/example/dimilkowska/android_cards/dao/CardDao;", "", "deleteCard", "", "card", "Lcom/example/dimilkowska/android_cards/entity/Card;", "getCardByName", "", "name", "", "getCards", "insertCard", "", "updateCard", "app_debug"})
public abstract interface CardDao {
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract long insertCard(@org.jetbrains.annotations.NotNull()
    com.example.dimilkowska.android_cards.entity.Card card);
    
    @android.arch.persistence.room.Update()
    public abstract void updateCard(@org.jetbrains.annotations.NotNull()
    com.example.dimilkowska.android_cards.entity.Card card);
    
    @android.arch.persistence.room.Delete()
    public abstract void deleteCard(@org.jetbrains.annotations.NotNull()
    com.example.dimilkowska.android_cards.entity.Card card);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM card WHERE name == :name")
    public abstract java.util.List<com.example.dimilkowska.android_cards.entity.Card> getCardByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM card")
    public abstract java.util.List<com.example.dimilkowska.android_cards.entity.Card> getCards();
}