package com.drplacid.warshipsassistant.model;

import androidx.annotation.NonNull;

import com.drplacid.warshipsassistant.model.dto.ApiResponseDTO;
import com.drplacid.warshipsassistant.model.dto.ShipDTO;
import com.drplacid.warshipsassistant.presenter.IDataProvider;
import com.drplacid.warshipsassistant.model.parameters.Nation;
import com.drplacid.warshipsassistant.model.parameters.Type;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WarshipsRepository {

    private static final String KEY = "647ea400ba637c56bea96355ddd0da4a";
    private static final String BASE_URL = "https://api.worldofwarships.ru/wows/encyclopedia/";
    final String REQUEST_FIELDS = "ship_id, name, nation, type, tier, is_premium, is_special, images";

    private Retrofit retrofit;

    public WarshipsRepository() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }

    public void initPreviewData(@NonNull Nation nation, @NonNull Type type, WeakReference<IDataProvider> callback) {

        IShipsApi api = retrofit.create(IShipsApi.class);
        Call<ApiResponseDTO> call = api.getShipsList(KEY, nation.getApiName(), type.getName(), REQUEST_FIELDS);

        call.enqueue(new Callback<ApiResponseDTO>() {
            @Override
            public void onResponse(Call<ApiResponseDTO> call, Response<ApiResponseDTO> response) {
                if (response.isSuccessful()) {
                    new Thread(() -> processPreviewData(response, callback))
                            .start();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseDTO> call, Throwable t) {
                callback.get().onConnectionErrorCallback();
                t.printStackTrace();
            }
        });
    }

    public void processPreviewData(@NonNull Response<ApiResponseDTO> response, WeakReference<IDataProvider> callbackWeakReference) {
        List<TierWrapper> tierList = new ArrayList<>();

        ApiResponseDTO apiResponse = response.body();

        List<ShipDTO> fullList = new ArrayList<>(apiResponse.getData().values());
        Collections.sort(fullList, (dto1, dto2) -> Integer.compare(dto1.getTier(), dto2.getTier()));

        TierWrapper tierWrapper = new TierWrapper(fullList.get(0).getTier());
        tierList.add(tierWrapper);

        for (ShipDTO dto : fullList) {
            if(dto.getTier() != tierWrapper.TIER) {
                tierWrapper = new TierWrapper(dto.getTier());
                tierList.add(tierWrapper);
            }
            tierWrapper.add(dto);
        }
        callbackWeakReference.get().onBranchDataReadyCallback(tierList);
    }


    public void getDetailedShipInfo(long shipId, WeakReference<IDataProvider> callback) {
        IShipsApi api = retrofit.create(IShipsApi.class);
        Call<ApiResponseDTO> call = api.getShip(KEY, shipId);

        call.enqueue(new Callback<ApiResponseDTO>() {
            @Override
            public void onResponse(Call<ApiResponseDTO> call, Response<ApiResponseDTO> response) {
                if (response.isSuccessful()) {
                    ShipDTO dto = response.body().getData().get(shipId);
                    callback.get().onDetailedDataReadyCallback(dto);
                }
            }

            @Override
            public void onFailure(Call<ApiResponseDTO> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
