package com.glowdubai_staff.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/glowdubai_staff/service/NetworkViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "lollipopNetworkCall", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getNetworkLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setNetworkLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "networkReceiver", "Landroid/content/BroadcastReceiver;", "networkRequest", "Landroid/net/NetworkRequest;", "getNetworkRequest", "()Landroid/net/NetworkRequest;", "setNetworkRequest", "(Landroid/net/NetworkRequest;)V", "disableNetworkListener", "", "context", "Landroid/content/Context;", "enableNetworkListener", "app_debug"})
public final class NetworkViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> networkLiveData;
    @org.jetbrains.annotations.Nullable()
    private android.net.NetworkRequest networkRequest;
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    private final android.net.ConnectivityManager.NetworkCallback lollipopNetworkCall = null;
    private final android.content.BroadcastReceiver networkReceiver = null;
    
    public NetworkViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getNetworkLiveData() {
        return null;
    }
    
    public final void setNetworkLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.NetworkRequest getNetworkRequest() {
        return null;
    }
    
    public final void setNetworkRequest(@org.jetbrains.annotations.Nullable()
    android.net.NetworkRequest p0) {
    }
    
    public final void enableNetworkListener(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
    
    public final void disableNetworkListener(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
}