package com.drplacid.warshipsassistant.view;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.drplacid.warshipsassistant.presenter.Presenter;
import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.TierWrapper;
import com.drplacid.warshipsassistant.model.dto.ShipDTO;
import com.drplacid.warshipsassistant.view.recycler.adapter.DetailedShipAdapter;
import com.drplacid.warshipsassistant.model.parameters.Nation;
import com.drplacid.warshipsassistant.model.parameters.Type;
import com.drplacid.warshipsassistant.view.recycler.adapter.NationAdapter;
import com.drplacid.warshipsassistant.view.recycler.adapter.TierAdapter;
import com.drplacid.warshipsassistant.view.recycler.adapter.TypeAdapter;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;


public class MainActivity extends MvpAppCompatActivity implements IViewMain, InteractionListener {

    @InjectPresenter
    Presenter presenter;

    ExpandableLayout typeExpandable;
    ExpandableLayout shipExpandable;

    RecyclerView nationSelector;
    RecyclerView typeSelector;
    RecyclerView shipSelector;
    RecyclerView shipInfo;

    DetailedShipAdapter detailedShipAdapter;

    int markerColor;
    int neutralColor;

    CardView currentNationCardView;
    CardView currentTypeCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeExpandable = findViewById(R.id.typeExpandable);
        shipExpandable = findViewById(R.id.shipExpandable);
        nationSelector = findViewById(R.id.nationSelectionRecycler);
        typeSelector = findViewById(R.id.typeSelectionRecycler);
        shipSelector = findViewById(R.id.commonBranchRecycler);
        shipInfo = findViewById(R.id.recyclerMainInfo);

        markerColor = this.getResources().getColor(R.color.coloMarker);
        neutralColor = this.getResources().getColor(R.color.colorTransparentBackground);

        onInitRecyclers();
    }


    private void onInitRecyclers() {
        nationSelector.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );
        typeSelector.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );
        shipSelector.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );
        shipInfo.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        nationSelector.setHasFixedSize(true);
        typeSelector.setHasFixedSize(true);
        shipSelector.setHasFixedSize(true);
        shipInfo.setHasFixedSize(true);


        detailedShipAdapter = new DetailedShipAdapter();
        shipInfo.setAdapter(detailedShipAdapter);
    }

    @Override
    public void displayNationsData(List<Nation> list) {
        this.runOnUiThread(() -> {
            NationAdapter nationAdapter = new NationAdapter(list);
            nationSelector.setAdapter(nationAdapter);
        });
    }

    @Override
    public void displayTypesData(List<Type> list) {
        this.runOnUiThread(() -> {
            typeExpandable.expand();
            TypeAdapter typeAdapter = new TypeAdapter(list);
            typeSelector.setAdapter(typeAdapter);
        });
    }

    @Override
    public void displayBranchData(List<TierWrapper> list) {
        this.runOnUiThread(() -> {
            shipExpandable.expand();
            TierAdapter tierAdapter = new TierAdapter(list);
            shipSelector.setAdapter(tierAdapter);
        });
    }

    @Override
    public void displayDetailedData(List<ShipDTO> list) {
        this.runOnUiThread(() -> {
            detailedShipAdapter.submitList(list);
            int position = list.size() - 1;
            if (position > 0) {
                shipInfo.smoothScrollToPosition(position);
            }
            unmarkItems(currentNationCardView, currentTypeCardView);
        });
    }

    @Override
    public void collapseTypeSelector() {
        typeExpandable.collapse();
    }

    @Override
    public void collapseShipSelector() {
        shipExpandable.collapse();
    }

    @Override
    public void showNoConnection() {
        this.runOnUiThread(() -> {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT)
                    .show();
            unmarkItems(currentNationCardView);
        });
    }

    @Override
    public void setNation(Nation nation, CardView cardView) {
        presenter.setNation(nation);
        markItem(currentNationCardView, cardView);
        this.currentNationCardView = cardView;
    }

    @Override
    public void setType(Type type, CardView cardView) {
        presenter.setType(type);
        markItem(currentTypeCardView, cardView);
        this.currentTypeCardView = cardView;
    }

    @Override
    public void setShip(long shipId) {
        presenter.setShip(shipId);
    }

    @Override
    public void removeShip(ShipDTO dto) {
        presenter.removeShip(dto);
    }

    private void markItem(CardView oldItem, CardView newItem) {
        if (oldItem != null) {
            oldItem.setCardBackgroundColor(neutralColor);
        }
        newItem.setCardBackgroundColor(markerColor);
    }

    private void unmarkItems(CardView... cardViews) {
        for (CardView c : cardViews) {
            if (c != null) {
                c.setCardBackgroundColor(neutralColor);
            }
        }
    }

}