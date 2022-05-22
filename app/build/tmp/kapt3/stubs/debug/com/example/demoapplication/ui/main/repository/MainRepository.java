package com.example.demoapplication.ui.main.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/demoapplication/ui/main/repository/MainRepository;", "", "apiHelper", "Lcom/example/demoapplication/service/ApiHelper;", "(Lcom/example/demoapplication/service/ApiHelper;)V", "callLocationAsync", "Landroidx/lifecycle/LiveData;", "Lcom/example/demoapplication/service/ApiResponse;", "Lcom/example/demoapplication/model/locationResponse/response/LocationResponse;", "latitude", "", "longitude", "page", "app_debug"})
public final class MainRepository {
    private final com.example.demoapplication.service.ApiHelper apiHelper = null;
    
    public MainRepository(@org.jetbrains.annotations.NotNull()
    com.example.demoapplication.service.ApiHelper apiHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.demoapplication.service.ApiResponse<com.example.demoapplication.model.locationResponse.response.LocationResponse>> callLocationAsync(@org.jetbrains.annotations.NotNull()
    java.lang.String latitude, @org.jetbrains.annotations.NotNull()
    java.lang.String longitude, @org.jetbrains.annotations.NotNull()
    java.lang.String page) {
        return null;
    }
}