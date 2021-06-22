package com.febryan.kisahnabi.api;

import com.febryan.kisahnabi.model.ResponseKisahNabi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("kisahnabi")
    Call<ResponseKisahNabi> getListKisahNabi();
}
