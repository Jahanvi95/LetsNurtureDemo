package com.example.demoapplication.utills;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/example/demoapplication/utills/VersionUtils;", "", "()V", "hasAndroidLPreview", "", "hasKitKat", "hasLollipop", "hasMarshmallow", "hasNougat", "hasNougatMR", "hasOreo", "app_debug"})
public final class VersionUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.demoapplication.utills.VersionUtils INSTANCE = null;
    
    private VersionUtils() {
        super();
    }
    
    /**
     * @return true if device is running API >= 19
     */
    public final boolean hasKitKat() {
        return false;
    }
    
    /**
     * @return true if device is running API >= 20
     */
    public final boolean hasAndroidLPreview() {
        return false;
    }
    
    /**
     * @return true if device is running API >= 21
     */
    public final boolean hasLollipop() {
        return false;
    }
    
    /**
     * @return true if device is running API >= 23
     */
    public final boolean hasMarshmallow() {
        return false;
    }
    
    /**
     * @return true if device is running API >= 24
     */
    public final boolean hasNougat() {
        return false;
    }
    
    /**
     * @return true if device is running API >= 24
     */
    public final boolean hasNougatMR() {
        return false;
    }
    
    /**
     * @return true if device is running API >= 26
     */
    public final boolean hasOreo() {
        return false;
    }
}