package com.example.demoapplication.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J1\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&\u00a2\u0006\u0002\u0010\u0017R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/example/demoapplication/base/BaseViewHolder;", "T", "Lcom/glowdubai_staff/BaseData;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "view", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "containerView", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "getView", "()Landroidx/databinding/ViewDataBinding;", "bind", "", "data", "listener", "Lcom/example/demoapplication/base/RecyclerAdapter$OnItemClickListener;", "viewModel", "Lcom/glowdubai_staff/base/BaseViewModel;", "position", "", "(Lcom/glowdubai_staff/BaseData;Lcom/example/demoapplication/base/RecyclerAdapter$OnItemClickListener;Lcom/glowdubai_staff/base/BaseViewModel;I)V", "LocationHolder", "TestHolder", "app_debug"})
public abstract class BaseViewHolder<T extends com.glowdubai_staff.BaseData> extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements kotlinx.android.extensions.LayoutContainer {
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ViewDataBinding view = null;
    
    public BaseViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ViewDataBinding view) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ViewDataBinding getView() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View getContainerView() {
        return null;
    }
    
    public abstract void bind(@org.jetbrains.annotations.NotNull()
    T data, @org.jetbrains.annotations.Nullable()
    com.example.demoapplication.base.RecyclerAdapter.OnItemClickListener listener, @org.jetbrains.annotations.NotNull()
    com.glowdubai_staff.base.BaseViewModel viewModel, int position);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/example/demoapplication/base/BaseViewHolder$TestHolder;", "Lcom/example/demoapplication/base/BaseViewHolder;", "Lcom/example/demoapplication/model/Test;", "parent", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/view/ViewGroup;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "bind", "", "data", "listener", "Lcom/example/demoapplication/base/RecyclerAdapter$OnItemClickListener;", "viewModel", "Lcom/glowdubai_staff/base/BaseViewModel;", "position", "", "app_debug"})
    public static final class TestHolder extends com.example.demoapplication.base.BaseViewHolder<com.example.demoapplication.model.Test> {
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        
        public TestHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        @android.annotation.SuppressLint(value = {"SetTextI18n", "UseCompatLoadingForDrawables"})
        @java.lang.Override()
        public void bind(@org.jetbrains.annotations.NotNull()
        com.example.demoapplication.model.Test data, @org.jetbrains.annotations.Nullable()
        com.example.demoapplication.base.RecyclerAdapter.OnItemClickListener listener, @org.jetbrains.annotations.NotNull()
        com.glowdubai_staff.base.BaseViewModel viewModel, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/example/demoapplication/base/BaseViewHolder$LocationHolder;", "Lcom/example/demoapplication/base/BaseViewHolder;", "Lcom/example/demoapplication/model/locationResponse/response/Data;", "parent", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/view/ViewGroup;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "bind", "", "data", "listener", "Lcom/example/demoapplication/base/RecyclerAdapter$OnItemClickListener;", "viewModel", "Lcom/glowdubai_staff/base/BaseViewModel;", "position", "", "app_debug"})
    public static final class LocationHolder extends com.example.demoapplication.base.BaseViewHolder<com.example.demoapplication.model.locationResponse.response.Data> {
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        
        public LocationHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        @android.annotation.SuppressLint(value = {"SetTextI18n", "UseCompatLoadingForDrawables"})
        @java.lang.Override()
        public void bind(@org.jetbrains.annotations.NotNull()
        com.example.demoapplication.model.locationResponse.response.Data data, @org.jetbrains.annotations.Nullable()
        com.example.demoapplication.base.RecyclerAdapter.OnItemClickListener listener, @org.jetbrains.annotations.NotNull()
        com.glowdubai_staff.base.BaseViewModel viewModel, int position) {
        }
    }
}