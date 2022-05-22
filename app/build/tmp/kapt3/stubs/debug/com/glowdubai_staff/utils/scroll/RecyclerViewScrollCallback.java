package com.glowdubai_staff.utils.scroll;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\"#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u001cH\u0002R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "builder", "Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback$Builder;", "(Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback$Builder;)V", "visibleThreshold", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "(ILandroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "currentPage", "layoutManagerType", "Lcom/glowdubai_staff/utils/scroll/LayoutManagerType;", "getLayoutManagerType", "()Lcom/glowdubai_staff/utils/scroll/LayoutManagerType;", "setLayoutManagerType", "(Lcom/glowdubai_staff/utils/scroll/LayoutManagerType;)V", "loading", "", "onScrolledListener", "Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback$OnScrolledListener;", "getOnScrolledListener", "()Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback$OnScrolledListener;", "setOnScrolledListener", "(Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback$OnScrolledListener;)V", "previousTotalItemCount", "startingPageIndex", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "resetState", "Builder", "OnScrolledListener", "app_debug"})
public final class RecyclerViewScrollCallback extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    private final int visibleThreshold = 0;
    private final androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = null;
    private int currentPage = 0;
    private int previousTotalItemCount = 0;
    private boolean loading = true;
    private final int startingPageIndex = 0;
    public com.glowdubai_staff.utils.scroll.LayoutManagerType layoutManagerType;
    public com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.OnScrolledListener onScrolledListener;
    
    public RecyclerViewScrollCallback(int visibleThreshold, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.glowdubai_staff.utils.scroll.LayoutManagerType getLayoutManagerType() {
        return null;
    }
    
    public final void setLayoutManagerType(@org.jetbrains.annotations.NotNull()
    com.glowdubai_staff.utils.scroll.LayoutManagerType p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.OnScrolledListener getOnScrolledListener() {
        return null;
    }
    
    public final void setOnScrolledListener(@org.jetbrains.annotations.NotNull()
    com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.OnScrolledListener p0) {
    }
    
    public RecyclerViewScrollCallback(@org.jetbrains.annotations.NotNull()
    com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.Builder builder) {
        super();
    }
    
    @java.lang.Override()
    public void onScrolled(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, int dx, int dy) {
    }
    
    private final void resetState() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback$OnScrolledListener;", "", "onScrolledToBottom", "", "page", "", "app_debug"})
    public static abstract interface OnScrolledListener {
        
        public abstract void onScrolledToBottom(int page);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback$Builder;", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "getLayoutManager$app_debug", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManagerType", "Lcom/glowdubai_staff/utils/scroll/LayoutManagerType;", "getLayoutManagerType$app_debug", "()Lcom/glowdubai_staff/utils/scroll/LayoutManagerType;", "setLayoutManagerType$app_debug", "(Lcom/glowdubai_staff/utils/scroll/LayoutManagerType;)V", "onScrolledListener", "Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback$OnScrolledListener;", "getOnScrolledListener$app_debug", "()Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback$OnScrolledListener;", "setOnScrolledListener$app_debug", "(Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback$OnScrolledListener;)V", "resetLoadingState", "", "getResetLoadingState$app_debug", "()Z", "setResetLoadingState$app_debug", "(Z)V", "visibleThreshold", "", "getVisibleThreshold$app_debug", "()I", "setVisibleThreshold$app_debug", "(I)V", "build", "Lcom/glowdubai_staff/utils/scroll/RecyclerViewScrollCallback;", "value", "app_debug"})
    public static final class Builder {
        @org.jetbrains.annotations.NotNull()
        private final androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = null;
        private int visibleThreshold = 7;
        @org.jetbrains.annotations.NotNull()
        private com.glowdubai_staff.utils.scroll.LayoutManagerType layoutManagerType = com.glowdubai_staff.utils.scroll.LayoutManagerType.LINEAR;
        public com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.OnScrolledListener onScrolledListener;
        private boolean resetLoadingState = false;
        
        public Builder(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.RecyclerView.LayoutManager getLayoutManager$app_debug() {
            return null;
        }
        
        public final int getVisibleThreshold$app_debug() {
            return 0;
        }
        
        public final void setVisibleThreshold$app_debug(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.glowdubai_staff.utils.scroll.LayoutManagerType getLayoutManagerType$app_debug() {
            return null;
        }
        
        public final void setLayoutManagerType$app_debug(@org.jetbrains.annotations.NotNull()
        com.glowdubai_staff.utils.scroll.LayoutManagerType p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.OnScrolledListener getOnScrolledListener$app_debug() {
            return null;
        }
        
        public final void setOnScrolledListener$app_debug(@org.jetbrains.annotations.NotNull()
        com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.OnScrolledListener p0) {
        }
        
        public final boolean getResetLoadingState$app_debug() {
            return false;
        }
        
        public final void setResetLoadingState$app_debug(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.Builder visibleThreshold(int value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.Builder onScrolledListener(@org.jetbrains.annotations.NotNull()
        com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.OnScrolledListener value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback.Builder resetLoadingState(boolean value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.glowdubai_staff.utils.scroll.RecyclerViewScrollCallback build() {
            return null;
        }
    }
}