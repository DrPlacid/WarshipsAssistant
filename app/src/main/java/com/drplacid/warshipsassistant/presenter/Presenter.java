package com.drplacid.warshipsassistant.presenter;

import com.drplacid.warshipsassistant.model.dto.ShipDTO;
import com.drplacid.warshipsassistant.model.TierWrapper;
import com.drplacid.warshipsassistant.model.WarshipsRepository;
import com.drplacid.warshipsassistant.view.IViewMain;
import com.drplacid.warshipsassistant.model.parameters.Nation;
import com.drplacid.warshipsassistant.model.parameters.Type;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import moxy.ViewStateProvider;

@InjectViewState
public class Presenter extends MvpPresenter<IViewMain> implements IDataProvider {

    private Nation nation;
    private Type type;

    private List<TierWrapper> branch;
    private Set<ShipDTO> ships = new LinkedHashSet<>();

    private WarshipsRepository repository;

    public Presenter() {
        List<Nation> nations = Arrays.asList(Nation.values());
        repository = new WarshipsRepository();

        getViewState().displayNationsData(nations);
    }

    public void reset() {
        this.nation = null;
        this.type = null;
    }

    public void removeShip(ShipDTO dto) {
        ships.remove(dto);
        getViewState().displayDetailedData(new ArrayList<>(ships));
    }

    public void setNation(Nation nation) {
        this.nation = nation;
        getViewState().collapseShipSelector();
        getViewState().collapseTypeSelector();
        List<Type> types = Arrays.asList(nation.getTypesAvailable());
        getViewState().displayTypesData(types);
    }

    public void setType(Type type) {
        this.type = type;
        repository.initPreviewData(this.nation, this.type, new WeakReference<>(this));
    }

    public void setShip(long shipId) {
        repository.getDetailedShipInfo(shipId, new WeakReference<>(this));
    }

    @Override
    public void onBranchDataReadyCallback(List<TierWrapper> list) {
        branch = list;
        provideBranchData();
    }

    @Override
    public void onDetailedDataReadyCallback(ShipDTO dto) {
        ships.add(dto);
        provideDetailedData();
    }

    @Override
    public void onConnectionErrorCallback() {
        getViewState().showNoConnection();
        getViewState().collapseTypeSelector();
    }

    @Override
    public void provideBranchData() {
        getViewState().displayBranchData(branch);
    }

    @Override
    public void provideDetailedData() {
        getViewState().displayDetailedData(new ArrayList<>(ships));
        getViewState().collapseTypeSelector();
        getViewState().collapseShipSelector();
    }

}
