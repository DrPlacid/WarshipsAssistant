package com.drplacid.warshipsassistant.view;

import com.drplacid.warshipsassistant.model.TierWrapper;
import com.drplacid.warshipsassistant.model.dto.ShipDTO;
import com.drplacid.warshipsassistant.model.parameters.Nation;
import com.drplacid.warshipsassistant.model.parameters.Type;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.SkipStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndStrategy.class)
public interface IViewMain extends MvpView {

    void displayNationsData(List<Nation> list);
    void displayTypesData(List<Type> list);
    void displayBranchData(List<TierWrapper> list);
    void displayDetailedData(List<ShipDTO> list);
    void collapseTypeSelector();
    void collapseShipSelector();

    @StateStrategyType(value = SkipStrategy.class)
    void showNoConnection();
}
