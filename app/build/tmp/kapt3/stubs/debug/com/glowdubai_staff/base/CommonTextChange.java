package com.glowdubai_staff.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00142\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00162\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00142\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/glowdubai_staff/base/CommonTextChange;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "position", "", "Ljava/lang/Integer;", "searchFor", "", "textChangeJob", "Lkotlinx/coroutines/Job;", "textChangeListener", "Lcom/glowdubai_staff/base/TextChangeListener;", "registerAutoCompleteTextView", "editText", "Landroid/widget/AutoCompleteTextView;", "registerDelayTextInputEditText", "Lcom/google/android/material/textfield/TextInputEditText;", "registerEditText", "Landroid/widget/EditText;", "registerTextInputEditText", "setCallback", "callback", "app_debug"})
public final class CommonTextChange implements kotlinx.coroutines.CoroutineScope {
    private java.lang.Integer position = 0;
    private com.glowdubai_staff.base.TextChangeListener textChangeListener;
    private java.lang.String searchFor = "";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.coroutines.CoroutineContext coroutineContext = null;
    private kotlinx.coroutines.Job textChangeJob;
    
    public CommonTextChange() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.glowdubai_staff.base.CommonTextChange setCallback(@org.jetbrains.annotations.NotNull()
    com.glowdubai_staff.base.TextChangeListener callback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.glowdubai_staff.base.CommonTextChange registerTextInputEditText(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText editText, int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.glowdubai_staff.base.CommonTextChange registerDelayTextInputEditText(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText editText, int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.glowdubai_staff.base.CommonTextChange registerEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText, int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.glowdubai_staff.base.CommonTextChange registerAutoCompleteTextView(@org.jetbrains.annotations.NotNull()
    android.widget.AutoCompleteTextView editText, int position) {
        return null;
    }
}