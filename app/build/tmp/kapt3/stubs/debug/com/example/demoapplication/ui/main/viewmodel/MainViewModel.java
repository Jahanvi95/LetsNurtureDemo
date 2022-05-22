package com.example.demoapplication.ui.main.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010%\u001a\u00020&2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\'\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u0010R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\nR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\f\u001a\u0004\b\r\u0010\nR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0011\u0010\nR1\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00160\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0017\u0010\nR!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001a\u0010\nR\u0016\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/example/demoapplication/ui/main/viewmodel/MainViewModel;", "Lcom/glowdubai_staff/base/BaseViewModel;", "mainRepository", "Lcom/example/demoapplication/ui/main/repository/MainRepository;", "application", "Landroid/app/Application;", "(Lcom/example/demoapplication/ui/main/repository/MainRepository;Landroid/app/Application;)V", "isNoDataVisible", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "isNoDataVisible$delegate", "Lkotlin/Lazy;", "isRecyclerViewVisible", "isRecyclerViewVisible$delegate", "latitude", "", "getLatitude", "latitude$delegate", "locationList", "Ljava/util/ArrayList;", "Lcom/example/demoapplication/model/locationResponse/response/Data;", "Lkotlin/collections/ArrayList;", "getLocationList", "locationList$delegate", "logitutde", "getLogitutde", "logitutde$delegate", "mContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "status", "Landroidx/lifecycle/MediatorLiveData;", "", "getStatus", "()Landroidx/lifecycle/MediatorLiveData;", "status$delegate", "callLocationAsync", "", "longitude", "page", "app_debug"})
public final class MainViewModel extends com.glowdubai_staff.base.BaseViewModel {
    private final com.example.demoapplication.ui.main.repository.MainRepository mainRepository = null;
    private final android.content.Context mContext = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy status$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy isRecyclerViewVisible$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy locationList$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy isNoDataVisible$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy latitude$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy logitutde$delegate = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.example.demoapplication.ui.main.repository.MainRepository mainRepository, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MediatorLiveData<java.lang.Object> getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isRecyclerViewVisible() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.demoapplication.model.locationResponse.response.Data>> getLocationList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isNoDataVisible() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getLatitude() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getLogitutde() {
        return null;
    }
    
    /**
     * location API
     */
    public final void callLocationAsync(@org.jetbrains.annotations.NotNull()
    java.lang.String latitude, @org.jetbrains.annotations.NotNull()
    java.lang.String longitude, @org.jetbrains.annotations.NotNull()
    java.lang.String page) {
    }
}