package com.glowdubai_staff.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ+\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0013\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\t\u001a\u00020\n*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\n\u0010\u0019\u001a\u00020\u0004*\u00020\fJ \u0010\u001a\u001a\u00020\n*\u00020\u00042\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\n0\u001cH\u0002J4\u0010\u001e\u001a\u0004\u0018\u0001H\u000f\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u0001*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u0001H\u000fH\u0086\n\u00a2\u0006\u0002\u0010 J\n\u0010!\u001a\u00020\u0011*\u00020\u0004J\n\u0010\"\u001a\u00020\u0011*\u00020\u0004J\u001f\u0010#\u001a\u00020\n*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0086\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006$"}, d2 = {"Lcom/glowdubai_staff/base/PreferenceHelper;", "", "()V", "myPref", "Landroid/content/SharedPreferences;", "getMyPref", "()Landroid/content/SharedPreferences;", "setMyPref", "(Landroid/content/SharedPreferences;)V", "clear", "", "context", "Landroid/content/Context;", "defaultPrefs", "getObject", "T", "key", "", "className", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "init", "removePreference", "saveObject", "value", "customPrefs", "edit", "operation", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "get", "defaultValue", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getLanguge", "getUserName", "set", "app_debug"})
public final class PreferenceHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.glowdubai_staff.base.PreferenceHelper INSTANCE = null;
    public static android.content.SharedPreferences myPref;
    
    private PreferenceHelper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getMyPref() {
        return null;
    }
    
    public final void setMyPref(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    public final void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences defaultPrefs(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences customPrefs(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$customPrefs) {
        return null;
    }
    
    private final void edit(android.content.SharedPreferences $this$edit, kotlin.jvm.functions.Function1<? super android.content.SharedPreferences.Editor, kotlin.Unit> operation) {
    }
    
    /**
     * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
     */
    public final void set(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences $this$set, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.Object value) {
    }
    
    /**
     * remove preference
     */
    public final void removePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public final void clear(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences $this$clear, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void saveObject(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.Object value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>T getObject(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> className) {
        return null;
    }
    
    public final void clear(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguge(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences $this$getLanguge) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserName(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences $this$getUserName) {
        return null;
    }
}