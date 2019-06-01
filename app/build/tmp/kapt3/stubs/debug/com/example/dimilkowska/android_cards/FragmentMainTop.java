package com.example.dimilkowska.android_cards;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/example/dimilkowska/android_cards/FragmentMainTop;", "Landroid/support/v4/app/Fragment;", "()V", "buttonOne", "Landroid/widget/Button;", "getButtonOne$app_debug", "()Landroid/widget/Button;", "setButtonOne$app_debug", "(Landroid/widget/Button;)V", "buttonThree", "getButtonThree$app_debug", "setButtonThree$app_debug", "mListener", "Lcom/example/dimilkowska/android_cards/FragmentMainTop$ButtonPressListener;", "getMListener$app_debug", "()Lcom/example/dimilkowska/android_cards/FragmentMainTop$ButtonPressListener;", "setMListener$app_debug", "(Lcom/example/dimilkowska/android_cards/FragmentMainTop$ButtonPressListener;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "ButtonPressListener", "app_debug"})
public final class FragmentMainTop extends android.support.v4.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private android.widget.Button buttonOne;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Button buttonThree;
    @org.jetbrains.annotations.Nullable()
    private com.example.dimilkowska.android_cards.FragmentMainTop.ButtonPressListener mListener;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getButtonOne$app_debug() {
        return null;
    }
    
    public final void setButtonOne$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getButtonThree$app_debug() {
        return null;
    }
    
    public final void setButtonThree$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.dimilkowska.android_cards.FragmentMainTop.ButtonPressListener getMListener$app_debug() {
        return null;
    }
    
    public final void setMListener$app_debug(@org.jetbrains.annotations.Nullable()
    com.example.dimilkowska.android_cards.FragmentMainTop.ButtonPressListener p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public FragmentMainTop() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/dimilkowska/android_cards/FragmentMainTop$ButtonPressListener;", "", "onButtonPressed", "", "button", "", "app_debug"})
    public static abstract interface ButtonPressListener {
        
        public abstract void onButtonPressed(int button);
    }
}