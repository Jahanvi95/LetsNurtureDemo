package com.example.demoapplication.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u0007H\'\u00a8\u0006\n"}, d2 = {"Lcom/example/demoapplication/service/APIServices;", "", "callLocationAsync", "Landroidx/lifecycle/LiveData;", "Lcom/example/demoapplication/service/ApiResponse;", "Lcom/example/demoapplication/model/locationResponse/response/LocationResponse;", "lang_id", "", "longitude", "page", "app_debug"})
public abstract interface APIServices {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "customer/restaurant/getsearchrestaurant")
    public abstract androidx.lifecycle.LiveData<com.example.demoapplication.service.ApiResponse<com.example.demoapplication.model.locationResponse.response.LocationResponse>> callLocationAsync(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "latitude")
    java.lang.String lang_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "longitude")
    java.lang.String longitude, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "page")
    java.lang.String page);
}