package workshop.akbolatss.designskillsone.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import workshop.akbolatss.designskillsone.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    protected RecyclerView rvTickets;

    private RvTicketsAdapter mTicketsAdapter;

    private List<TicketModel> mTicketModels;
    private List<FlightModel> mFlightModels;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);

        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.tvToolbarMain);

            getSupportActionBar().setIcon(R.drawable.ic_menu_24dp);
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        initTickets();
    }

    private void initTickets() {
        rvTickets.setHasFixedSize(true);
        rvTickets.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mTicketModels = new ArrayList<>();

        mFlightModels = new ArrayList<>();
        mFlightModels.add(new FlightModel("AKHMETOV", "Алма-Ата  -  Астана  /  30.12.2016"));
        mFlightModels.add(new FlightModel("MAZENTSEV", "Астана  -  Алма-Ата  /  01.01.2017"));
        mFlightModels.add(new FlightModel("MUKHORYAPOV", "Москва  -  Санкт-Петербург  /  03.03.2017"));
        mTicketModels.add(new TicketModel("№ 201245123", "23.10.2016", true, false, mFlightModels));

        mFlightModels = new ArrayList<>();
        mFlightModels.add(new FlightModel("AKHMETOV", "Алма-Ата  -  Астана  /  30.12.2016"));
        mFlightModels.add(new FlightModel("MAZENTSEV", "Астана  -  Алма-Ата  /  01.01.2017"));
        mTicketModels.add(new TicketModel("№ 201245123", "23.10.2016", false,false, mFlightModels));

        mFlightModels = new ArrayList<>();
        mFlightModels.add(new FlightModel("AKHMETOV", "Алма-Ата  -  Астана  /  30.12.2016"));
        mFlightModels.add(new FlightModel("MAZENTSEV", "Астана  -  Алма-Ата  /  01.01.2017"));
        mTicketModels.add(new TicketModel("№ 201245123", "23.10.2016", false,true, mFlightModels));

        mTicketsAdapter = new RvTicketsAdapter(mTicketModels);
        rvTickets.setAdapter(mTicketsAdapter);
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }
}
