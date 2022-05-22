package com.example.demoapplication.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/example/demoapplication/base/UpdateDataListenerList;", "", "onUpdateList", "", "data", "Ljava/util/ArrayList;", "Lcom/example/demoapplication/model/Test;", "Lkotlin/collections/ArrayList;", "position", "", "app_debug"})
public abstract interface UpdateDataListenerList {
    
    public abstract void onUpdateList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.demoapplication.model.Test> data, int position);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}