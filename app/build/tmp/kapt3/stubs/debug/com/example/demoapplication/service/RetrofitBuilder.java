package com.example.demoapplication.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/demoapplication/service/RetrofitBuilder;", "", "()V", "apiService", "Lcom/example/demoapplication/service/APIServices;", "getApiService", "()Lcom/example/demoapplication/service/APIServices;", "setApiService", "(Lcom/example/demoapplication/service/APIServices;)V", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getRetrofit", "Lretrofit2/Retrofit;", "getRetrofitData", "", "provideLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideOkHttpClient", "interceptor", "app_debug"})
public final class RetrofitBuilder {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.demoapplication.service.RetrofitBuilder INSTANCE = null;
    private static final okhttp3.OkHttpClient okHttpClient = null;
    private static io.reactivex.disposables.CompositeDisposable mCompositeDisposable;
    @org.jetbrains.annotations.NotNull()
    private static com.example.demoapplication.service.APIServices apiService;
    
    private RetrofitBuilder() {
        super();
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    public final void getRetrofitData() {
    }
    
    private final okhttp3.OkHttpClient provideOkHttpClient(okhttp3.logging.HttpLoggingInterceptor interceptor) {
        return null;
    }
    
    private final okhttp3.logging.HttpLoggingInterceptor provideLoggingInterceptor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapplication.service.APIServices getApiService() {
        return null;
    }
    
    public final void setApiService(@org.jetbrains.annotations.NotNull()
    com.example.demoapplication.service.APIServices p0) {
    }
}