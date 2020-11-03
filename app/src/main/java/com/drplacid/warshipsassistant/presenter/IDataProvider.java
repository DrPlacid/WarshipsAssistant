package com.drplacid.warshipsassistant.presenter;

import android.graphics.Bitmap;

import com.drplacid.warshipsassistant.model.TierWrapper;
import com.drplacid.warshipsassistant.model.dto.ShipDTO;

import java.util.List;

public interface IDataProvider {
    void provideBranchData();
    void provideDetailedData();

    void onBranchDataReadyCallback(List<TierWrapper> list);
    void onDetailedDataReadyCallback(ShipDTO dto);
    void onConnectionErrorCallback();
}
