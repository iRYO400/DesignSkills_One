package workshop.akbolatss.designskillsone.second;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import workshop.akbolatss.designskillsone.R;

/**
 * Author: Akbolat Sadvakassov
 * Date: 23.11.2017
 */

public class RvOrdersAdapter extends RecyclerView.Adapter<RvOrdersAdapter.ExchangeVH> {

    List<OrderModel> modelList;

    public RvOrdersAdapter(List<OrderModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ExchangeVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_detail_item, parent, false);
        return new ExchangeVH(view);
    }

    @Override
    public void onBindViewHolder(ExchangeVH holder, int position) {
        OrderModel orderModel = modelList.get(position);
        holder.bind(orderModel);
    }

    @Override
    public int getItemCount() {
        if (modelList == null) {
            return 0;
        }
        return modelList.size();
    }

    class ExchangeVH extends RecyclerView.ViewHolder {

        Context mContext;
        @BindView(R.id.tvFlightNum)
        TextView tvFlightNum;
        @BindView(R.id.imgLogo)
        ImageView imgLogo;
        @BindView(R.id.tvFlightName)
        TextView tvFlightName;
        @BindView(R.id.tvStartTime)
        TextView tvStartTime;
        @BindView(R.id.tvStartCity)
        TextView tvStartCity;
        @BindView(R.id.tvStartDate)
        TextView tvStartDate;

        @BindView(R.id.tvFlightTime)
        TextView tvFlightTime;

        @BindView(R.id.tvEndTime)
        TextView tvEndTime;
        @BindView(R.id.tvEndCity)
        TextView tvEndCity;
        @BindView(R.id.tvEndDate)
        TextView tvEndDate;

        @BindView(R.id.layoutWaiting)
        LinearLayout layoutWaiting;
        @BindView(R.id.tvWaitTime)
        TextView tvWaitTime;

        ExchangeVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        void bind(OrderModel orderModel) {

            tvFlightNum.setText(orderModel.getFlightNum());
            //Picasso.load(orderModel.getCompanyLogo())
            //.into(imgLogo);
            tvFlightName.setText(orderModel.getFlightName());
            tvStartTime.setText(orderModel.getStartTime());
            tvStartCity.setText(orderModel.getStartCityCode());
            tvStartDate.setText(orderModel.getStartDate());

            tvFlightTime.setText(orderModel.getFlightTime());

            tvEndTime.setText(orderModel.getEndTime());
            tvEndCity.setText(orderModel.getEndCityCode());
            tvEndDate.setText(orderModel.getEndDate());

            if (orderModel.isHaveWaitTime()) {
                layoutWaiting.setVisibility(View.VISIBLE);
                tvWaitTime.setText(orderModel.getWaitTime());
            } else {
                layoutWaiting.setVisibility(View.GONE);
            }
        }
    }
}
