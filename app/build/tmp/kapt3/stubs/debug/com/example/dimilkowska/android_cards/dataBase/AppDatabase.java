package com.example.dimilkowska.android_cards.dataBase;

import java.lang.System;

@android.arch.persistence.room.TypeConverters(value = {com.example.dimilkowska.android_cards.converter.DateTypeConverter.class})
@android.arch.persistence.room.Database(entities = {com.example.dimilkowska.android_cards.entity.Card.class, com.example.dimilkowska.android_cards.entity.Transaction.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/example/dimilkowska/android_cards/dataBase/AppDatabase;", "Landroid/arch/persistence/room/RoomDatabase;", "()V", "cardDao", "Lcom/example/dimilkowska/android_cards/dao/CardDao;", "transactionDao", "Lcom/example/dimilkowska/android_cards/dao/TransactionDao;", "Companion", "app_debug"})
public abstract class AppDatabase extends android.arch.persistence.room.RoomDatabase {
    @org.jetbrains.annotations.Nullable()
    private static com.example.dimilkowska.android_cards.dataBase.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private static final android.arch.persistence.room.migration.Migration MIGRATION_1_2 = null;
    public static final com.example.dimilkowska.android_cards.dataBase.AppDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.dimilkowska.android_cards.dao.CardDao cardDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.dimilkowska.android_cards.dao.TransactionDao transactionDao();
    
    public AppDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/example/dimilkowska/android_cards/dataBase/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/dimilkowska/android_cards/dataBase/AppDatabase;", "getINSTANCE", "()Lcom/example/dimilkowska/android_cards/dataBase/AppDatabase;", "setINSTANCE", "(Lcom/example/dimilkowska/android_cards/dataBase/AppDatabase;)V", "MIGRATION_1_2", "Landroid/arch/persistence/room/migration/Migration;", "getMIGRATION_1_2", "()Landroid/arch/persistence/room/migration/Migration;", "destroyDataBase", "", "getAppDataBase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.dimilkowska.android_cards.dataBase.AppDatabase getINSTANCE() {
            return null;
        }
        
        public final void setINSTANCE(@org.jetbrains.annotations.Nullable()
        com.example.dimilkowska.android_cards.dataBase.AppDatabase p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.arch.persistence.room.migration.Migration getMIGRATION_1_2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.dimilkowska.android_cards.dataBase.AppDatabase getAppDataBase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        public final void destroyDataBase() {
        }
        
        private Companion() {
            super();
        }
    }
}