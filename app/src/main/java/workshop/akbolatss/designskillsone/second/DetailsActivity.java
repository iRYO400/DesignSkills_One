package workshop.akbolatss.designskillsone.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import workshop.akbolatss.designskillsone.R;

public class DetailsActivity extends AppCompatActivity {


    @BindView(R.id.rvOrder)
    protected RecyclerView rvOrder;
    private RvOrdersAdapter mRvOrdersAdapter;
    private List<OrderModel> mOrderModels;

    @BindView(R.id.rvPassenger)
    protected RecyclerView rvPassenger;
    private RvPassengersAdapter mRvPassengersAdapter;
    private List<PassengerModel> mPassengerModels;

    @BindView(R.id.rvExchange)
    protected RecyclerView rvExchange;
    private RvExchangesAdapter mRvExchangesAdapter;
    private List<ExchangeModel> mExchangeModels;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mUnbinder = ButterKnife.bind(this);

        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.tvToolbarDetails);
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        initOrders();
        initPassengers();
        initExchanges();
    }


    private void initOrders() {
        rvOrder.setHasFixedSize(true);
        rvOrder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mOrderModels = new ArrayList<>();
        mOrderModels.add(new OrderModel("538",
                "http://company-logo.png",
                "Семипалатинск - Усть-Каменогорск",
                "06:35",
                "SEM",
                "23.10.2016",
                "2ч 40м",
                "08:45",
                "UST",
                "23.10.2016",
                true,
                "15 ч 20м"));

        mOrderModels.add(new OrderModel("539",
                "http://company-logo.png",
                "Усть-Каменогорск - Астана",
                "23:05",
                "UST",
                "24.10.2016",
                "4ч 55м",
                "04:00",
                "AST",
                "24.10.2016",
                false,
                ""));

        mRvOrdersAdapter = new RvOrdersAdapter(mOrderModels);
        rvOrder.setAdapter(mRvOrdersAdapter);

    }

    private void initPassengers() {
        rvPassenger.setHasFixedSize(true);
        rvPassenger.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mPassengerModels = new ArrayList<>();
        mPassengerModels.add(new PassengerModel("Malayev Dauren", "037750091"));
        mPassengerModels.add(new PassengerModel("Daulet Aisana", "213412345"));

        mRvPassengersAdapter = new RvPassengersAdapter(mPassengerModels);
        rvPassenger.setAdapter(mRvPassengersAdapter);
    }

    private void initExchanges() {
        rvExchange.setHasFixedSize(true);
        rvExchange.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        mExchangeModels = new ArrayList<>();
        mExchangeModels.add(new ExchangeModel("№ 201245123",
                "AKHMETOV",
                "Страхование жизни\n20.12.2016 - 31.12.2016",
                1,
                true,
                "23.10.2016"));

        mExchangeModels.add(new ExchangeModel("№ 201245123",
                "MAZENTCEV",
                "Авиабилет\nАлматы - Семипалатинск",
                3,
                false,
                "23.10.2016"));

        mRvExchangesAdapter = new RvExchangesAdapter(mExchangeModels);
        rvExchange.setAdapter(mRvExchangesAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @OnClick(R.id.btnBack)
    protected void onBack() {
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }
}
