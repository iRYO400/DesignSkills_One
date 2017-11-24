package workshop.akbolatss.designskillsone.second;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class RvPassengersAdapter extends RecyclerView.Adapter<RvPassengersAdapter.ExchangeVH> {

    List<PassengerModel> modelList;

    public RvPassengersAdapter(List<PassengerModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ExchangeVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_passengers, parent, false);
        return new ExchangeVH(view);
    }

    @Override
    public void onBindViewHolder(ExchangeVH holder, int position) {
        PassengerModel passengerModel = modelList.get(position);
        holder.bind(passengerModel);
    }

    @Override
    public int getItemCount() {
        if (modelList == null) {
            return 0;
        }
        Log.d("TAG", "Size " + modelList.size());
        return modelList.size();
    }

    class ExchangeVH extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvId)
        TextView tvId;

        ExchangeVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        void bind(PassengerModel passengerModel) {
            tvName.setText(passengerModel.getName());
            tvId.setText(passengerModel.getId());
        }
    }
}
