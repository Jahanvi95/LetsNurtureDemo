package com.example.demoapplication.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003:\u0001#B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u001e\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0014\u0010\u001d\u001a\u00020\u00172\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bJ5\u0010\u001e\u001a\u00020\u00172\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u001fj\b\u0012\u0004\u0012\u00028\u0000` 2\u0006\u0010!\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0013H\u0007\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/demoapplication/base/RecyclerAdapter;", "T", "Lcom/glowdubai_staff/BaseData;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/demoapplication/base/BaseViewHolder;", "context", "Landroid/content/Context;", "dataSet", "", "viewModel", "Lcom/glowdubai_staff/base/BaseViewModel;", "listener", "Lcom/example/demoapplication/base/RecyclerAdapter$OnItemClickListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/glowdubai_staff/base/BaseViewModel;Lcom/example/demoapplication/base/RecyclerAdapter$OnItemClickListener;)V", "getListener", "()Lcom/example/demoapplication/base/RecyclerAdapter$OnItemClickListener;", "setListener", "(Lcom/example/demoapplication/base/RecyclerAdapter$OnItemClickListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "setNotifyData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dataSets", "(Ljava/util/ArrayList;Lcom/glowdubai_staff/BaseData;I)V", "OnItemClickListener", "app_debug"})
public final class RecyclerAdapter<T extends com.glowdubai_staff.BaseData> extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.demoapplication.base.BaseViewHolder<T>> {
    private android.content.Context context;
    private java.util.List<? extends T> dataSet;
    private com.glowdubai_staff.base.BaseViewModel viewModel;
    @org.jetbrains.annotations.Nullable()
    private com.example.demoapplication.base.RecyclerAdapter.OnItemClickListener listener;
    
    public RecyclerAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> dataSet, @org.jetbrains.annotations.NotNull()
    com.glowdubai_staff.base.BaseViewModel viewModel, @org.jetbrains.annotations.Nullable()
    com.example.demoapplication.base.RecyclerAdapter.OnItemClickListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.demoapplication.base.RecyclerAdapter.OnItemClickListener getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.Nullable()
    com.example.demoapplication.base.RecyclerAdapter.OnItemClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @java.lang.Override()
    public com.example.demoapplication.base.BaseViewHolder<T> onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> dataSet) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setNotifyData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<T> dataSet, @org.jetbrains.annotations.NotNull()
    T dataSets, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.demoapplication.base.BaseViewHolder<T> holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/example/demoapplication/base/RecyclerAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "T", "Lcom/glowdubai_staff/BaseData;", "string", "", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position, @org.jetbrains.annotations.NotNull()
        com.glowdubai_staff.BaseData T, @org.jetbrains.annotations.NotNull()
        java.lang.String string);
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
        public static final class DefaultImpls {
        }
    }
}