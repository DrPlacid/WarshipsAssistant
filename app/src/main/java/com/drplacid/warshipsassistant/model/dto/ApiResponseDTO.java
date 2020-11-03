package com.drplacid.warshipsassistant.model.dto;

import androidx.annotation.NonNull;

import com.drplacid.warshipsassistant.model.TierWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import retrofit2.Response;

public class ApiResponseDTO {

    private Map<Long, ShipDTO> data;

    public Map<Long, ShipDTO> getData() {
        return data;
    }

}
