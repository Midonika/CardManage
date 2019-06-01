package com.example.dimilkowska.android_cards;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/example/dimilkowska/android_cards/MyMainActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/example/dimilkowska/android_cards/FragmentMainTop$ButtonPressListener;", "()V", "cardDao", "Lcom/example/dimilkowska/android_cards/dao/CardDao;", "db", "Lcom/example/dimilkowska/android_cards/dataBase/AppDatabase;", "getDb", "()Lcom/example/dimilkowska/android_cards/dataBase/AppDatabase;", "setDb", "(Lcom/example/dimilkowska/android_cards/dataBase/AppDatabase;)V", "items", "Ljava/util/ArrayList;", "Lcom/example/dimilkowska/android_cards/entity/Card;", "getItems$app_debug", "()Ljava/util/ArrayList;", "setItems$app_debug", "(Ljava/util/ArrayList;)V", "onButtonPressed", "", "button", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "replaceFragment", "frag", "Landroid/support/v4/app/Fragment;", "index", "app_debug"})
public final class MyMainActivity extends android.support.v7.app.AppCompatActivity implements com.example.dimilkowska.android_cards.FragmentMainTop.ButtonPressListener {
    @org.jetbrains.annotations.Nullable()
    private com.example.dimilkowska.android_cards.dataBase.AppDatabase db;
    private com.example.dimilkowska.android_cards.dao.CardDao cardDao;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.dimilkowska.android_cards.entity.Card> items;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.dimilkowska.android_cards.dataBase.AppDatabase getDb() {
        return null;
    }
    
    public final void setDb(@org.jetbrains.annotations.Nullable()
    com.example.dimilkowska.android_cards.dataBase.AppDatabase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.dimilkowska.android_cards.entity.Card> getItems$app_debug() {
        return null;
    }
    
    public final void setItems$app_debug(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.dimilkowska.android_cards.entity.Card> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void replaceFragment(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.Fragment frag) {
    }
    
    public final void replaceFragment(int index) {
    }
    
    @java.lang.Override()
    public void onButtonPressed(int button) {
    }
    
    public MyMainActivity() {
        super();
    }
}