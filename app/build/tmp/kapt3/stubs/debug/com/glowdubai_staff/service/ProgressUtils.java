package com.glowdubai_staff.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u000f\u001a\u00020\rH\u0007J\b\u0010\u0010\u001a\u00020\rH\u0007J\u0006\u0010\u0011\u001a\u00020\rJ&\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/glowdubai_staff/service/ProgressUtils;", "Landroidx/lifecycle/LifecycleObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "context", "Landroid/content/Context;", "(Landroidx/lifecycle/Lifecycle;Landroid/content/Context;)V", "m_Context", "(Landroid/content/Context;)V", "mContext", "mProgressDialog", "Lcom/example/demoapplication/service/CustomProgressDialog;", "hide", "", "init", "onDestroy", "onStop", "remove", "show", "isCancel", "", "message", "", "mainMessage", "app_debug"})
public final class ProgressUtils implements androidx.lifecycle.LifecycleObserver {
    private final android.content.Context mContext = null;
    private com.example.demoapplication.service.CustomProgressDialog mProgressDialog;
    
    public ProgressUtils(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Lifecycle lifecycle, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public ProgressUtils(@org.jetbrains.annotations.NotNull()
    android.content.Context m_Context) {
        super();
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_CREATE)
    public final void init() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_STOP)
    public final void onStop() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
    }
    
    public final void remove() {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void show() {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void show(boolean isCancel) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void show(boolean isCancel, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void show(boolean isCancel, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String mainMessage) {
    }
    
    /**
     * Hide Progress dialog
     */
    public final void hide() {
    }
}