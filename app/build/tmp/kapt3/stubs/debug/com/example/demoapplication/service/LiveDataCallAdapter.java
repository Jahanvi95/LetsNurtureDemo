package com.example.demoapplication.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001a\u0012\u0004\u0012\u0002H\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u00030\u00022\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\"\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/demoapplication/service/LiveDataCallAdapter;", "R", "Lretrofit2/CallAdapter;", "Landroidx/lifecycle/LiveData;", "Lcom/example/demoapplication/service/ApiResponse;", "Landroidx/lifecycle/LifecycleObserver;", "responseType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "adapt", "call", "Lretrofit2/Call;", "app_debug"})
public final class LiveDataCallAdapter<R extends java.lang.Object> implements retrofit2.CallAdapter<R, androidx.lifecycle.LiveData<com.example.demoapplication.service.ApiResponse<R>>>, androidx.lifecycle.LifecycleObserver {
    private final java.lang.reflect.Type responseType = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    public LiveDataCallAdapter(@org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type responseType) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.demoapplication.service.ApiResponse<R>> adapt(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<R> call) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.reflect.Type responseType() {
        return null;
    }
}