package com.drplacid.warshipsassistant.model;


import com.drplacid.warshipsassistant.model.dto.ApiResponseDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IShipsApi {

    @GET("ships/")
    Call<ApiResponseDTO> getShipsList(
            @Query("application_id") String apiKey,
            @Query("nation") String nation,
            @Query("type") String type,
            @Query("fields") String fields
    );

    @GET("ships/")
    Call<ApiResponseDTO> getShip(
            @Query("application_id") String apiKey,
            @Query("ship_id") Long shipId
    );
}
