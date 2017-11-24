package workshop.akbolatss.designskillsone.first;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import workshop.akbolatss.designskillsone.R;

/**
 * Author: Akbolat Sadvakassov
 * Date: 23.11.2017
 */

public class RvFlightsAdapter extends RecyclerView.Adapter<RvFlightsAdapter.FlightVH> {

    List<FlightModel> modelList;

    public RvFlightsAdapter(List<FlightModel> flightModels) {
        this.modelList = flightModels;
    }

    @Override
    public FlightVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_inner_item, parent, false);
        return new RvFlightsAdapter.FlightVH(view);
    }

    @Override
    public void onBindViewHolder(FlightVH holder, int position) {
        FlightModel flightModel = modelList.get(position);
        holder.bind(flightModel);
    }

    @Override
    public int getItemCount() {
        if (modelList == null) {
            return 0;
        }
        return modelList.size();
    }

    class FlightVH extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvFlight)
        TextView tvFlight;

        FlightVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(FlightModel flightModel) {
            tvName.setText(flightModel.getName());
            tvFlight.setText(flightModel.getFlight());
        }
    }
}
