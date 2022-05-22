package com.example.demoapplication.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0003\u0082\u0001\u0006\u0005\u0006\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/demoapplication/service/ApiResponse;", "T", "", "()V", "Companion", "Lcom/example/demoapplication/service/ApiEmptyResponse;", "Lcom/example/demoapplication/service/ApiErrorResponse;", "Lcom/example/demoapplication/service/ApiSuccessResponse;", "Lcom/example/demoapplication/service/ApiLoading;", "Lcom/example/demoapplication/service/NoInternet;", "Lcom/example/demoapplication/service/Validation;", "app_debug"})
public abstract class ApiResponse<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.demoapplication.service.ApiResponse.Companion Companion = null;
    
    private ApiResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\b\"\u0004\b\u0001\u0010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\r\"\u0004\b\u0001\u0010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fJ\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0011\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0012\u001a\u00020\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/example/demoapplication/service/ApiResponse$Companion;", "", "()V", "create", "Lcom/example/demoapplication/service/ApiLoading;", "T", "isLoadingShow", "", "Lcom/example/demoapplication/service/ApiErrorResponse;", "errorCode", "", "error", "", "Lcom/example/demoapplication/service/ApiResponse;", "response", "Lretrofit2/Response;", "network", "Lcom/example/demoapplication/service/NoInternet;", "isNetwork", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>com.example.demoapplication.service.ApiResponse<T> create(@org.jetbrains.annotations.NotNull()
        retrofit2.Response<T> response) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>com.example.demoapplication.service.ApiErrorResponse<T> create(int errorCode, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable error) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>com.example.demoapplication.service.ApiLoading<T> create(boolean isLoadingShow) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>com.example.demoapplication.service.NoInternet<T> network(boolean isNetwork) {
            return null;
        }
    }
}