package com.example.demoapplication.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0003J\u0006\u0010*\u001a\u00020)J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\u0012\u0010-\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0015J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0017H&J\b\u00102\u001a\u00020)H\u0014J\u0010\u00103\u001a\u00020)2\b\b\u0002\u00104\u001a\u00020\u0017J$\u00105\u001a\u00020)2\b\b\u0002\u00106\u001a\u00020\u00172\b\b\u0002\u00107\u001a\u00020#2\b\b\u0002\u00108\u001a\u00020#R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'\u00a8\u00069"}, d2 = {"Lcom/example/demoapplication/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mProgressUtil", "Lcom/glowdubai_staff/service/ProgressUtils;", "getMProgressUtil", "()Lcom/glowdubai_staff/service/ProgressUtils;", "setMProgressUtil", "(Lcom/glowdubai_staff/service/ProgressUtils;)V", "networkViewModel", "Lcom/glowdubai_staff/service/NetworkViewModel;", "getNetworkViewModel", "()Lcom/glowdubai_staff/service/NetworkViewModel;", "networkViewModel$delegate", "Lkotlin/Lazy;", "notificationCount", "Landroidx/lifecycle/MutableLiveData;", "", "getNotificationCount", "()Landroidx/lifecycle/MutableLiveData;", "setNotificationCount", "(Landroidx/lifecycle/MutableLiveData;)V", "onCreateNetwork", "", "getOnCreateNetwork", "()Z", "setOnCreateNetwork", "(Z)V", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "setPrefs", "(Landroid/content/SharedPreferences;)V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "addStatusBarColor", "", "hideProgress", "initProgress", "listenNetworkState", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNetWorkChange", "onNetworkChange", "onPause", "setFullScreen", "isFull", "showProgress", "isCancelable", "message", "mainMessage", "app_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity {
    public android.content.SharedPreferences prefs;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String token = "";
    private final kotlin.Lazy networkViewModel$delegate = null;
    private boolean onCreateNetwork = false;
    @org.jetbrains.annotations.Nullable()
    private com.glowdubai_staff.service.ProgressUtils mProgressUtil;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> notificationCount;
    private java.util.HashMap _$_findViewCache;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getPrefs() {
        return null;
    }
    
    public final void setPrefs(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final com.glowdubai_staff.service.NetworkViewModel getNetworkViewModel() {
        return null;
    }
    
    public final boolean getOnCreateNetwork() {
        return false;
    }
    
    public final void setOnCreateNetwork(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.glowdubai_staff.service.ProgressUtils getMProgressUtil() {
        return null;
    }
    
    public final void setMProgressUtil(@org.jetbrains.annotations.Nullable()
    com.glowdubai_staff.service.ProgressUtils p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getNotificationCount() {
        return null;
    }
    
    public final void setNotificationCount(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Set Status bar color
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    private final void addStatusBarColor() {
    }
    
    private final void initProgress() {
    }
    
    public final void showProgress(boolean isCancelable, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String mainMessage) {
    }
    
    public final void hideProgress() {
    }
    
    private final void listenNetworkState() {
    }
    
    /**
     * on network change this method will call
     */
    public abstract void onNetWorkChange(boolean onNetworkChange);
    
    public final void setFullScreen(boolean isFull) {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
}