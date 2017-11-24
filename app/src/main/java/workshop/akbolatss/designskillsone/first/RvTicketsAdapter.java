package workshop.akbolatss.designskillsone.first;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import workshop.akbolatss.designskillsone.R;
import workshop.akbolatss.designskillsone.second.DetailsActivity;

/**
 * Author: Akbolat Sadvakassov
 * Date: 23.11.2017
 */

public class RvTicketsAdapter extends RecyclerView.Adapter<RvTicketsAdapter.TicketsVH> {

    List<TicketModel> modelList;

    public RvTicketsAdapter(List<TicketModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public TicketsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_item, parent, false);
        return new TicketsVH(view);
    }

    @Override
    public void onBindViewHolder(TicketsVH holder, int position) {
        TicketModel ticketModel = modelList.get(position);
        holder.bind(ticketModel);
    }

    @Override
    public int getItemCount() {
        if (modelList == null) {
            return 0;
        }
        return modelList.size();
    }

    class TicketsVH extends RecyclerView.ViewHolder {

        Context mContext;
        @BindView(R.id.frameLayout)
        FrameLayout frameLayout;
        @BindView(R.id.tvNum)
        TextView tvNum;
        @BindView(R.id.tvDate)
        TextView tvDate;
        @BindView(R.id.imgPass)
        ImageView imgPass;
        @BindView(R.id.tvPass)
        TextView tvPass;
        @BindView(R.id.imgType)
        ImageView imgType;
        @BindView(R.id.recyclerView)
        RecyclerView rView;
        RvFlightsAdapter rvAdapter;

        TicketsVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        void bind(TicketModel ticketModel) {
            tvNum.setText(ticketModel.getNumber());
            tvDate.setText(ticketModel.getDate());
            if (ticketModel.isPassed()) {
                imgPass.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_check_circle_black_24dp));
                tvPass.setText(R.string.passed);
                imgType.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_confirmation_number_24dp));
            } else if (ticketModel.isPending()) {
                imgPass.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_access_time_24dp));
                tvPass.setText(R.string.pending);
                imgType.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_verified_user_24dp));
            } else {
                imgPass.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_cancel_black_24dp));
                tvPass.setText(R.string.cancelled);
                imgType.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_work_24dp));
            }

            rView.setHasFixedSize(true);
            rView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            rView.setNestedScrollingEnabled(false);

            rvAdapter = new RvFlightsAdapter(ticketModel.getFlightModels());
            rView.setAdapter(rvAdapter);

            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mContext.startActivity(new Intent(mContext, DetailsActivity.class));
                }
            });
        }
    }
}
