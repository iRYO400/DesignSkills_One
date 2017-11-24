package workshop.akbolatss.designskillsone.second;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import workshop.akbolatss.designskillsone.R;

/**
 * Author: Akbolat Sadvakassov
 * Date: 23.11.2017
 */

public class RvExchangesAdapter extends RecyclerView.Adapter<RvExchangesAdapter.ExchangeVH> {

    List<ExchangeModel> modelList;

    public RvExchangesAdapter(List<ExchangeModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ExchangeVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_exchange_item, parent, false);
        return new ExchangeVH(view);
    }

    @Override
    public void onBindViewHolder(ExchangeVH holder, int position) {
        ExchangeModel exchangeModel = modelList.get(position);
        holder.bind(exchangeModel);
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

        Context mContext;
        @BindView(R.id.tvNum)
        TextView tvNum;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvDescription)
        TextView tvDescription;
        @BindView(R.id.imgType)
        ImageView imgType;
        @BindView(R.id.imgPass)
        ImageView imgPass;
        @BindView(R.id.tvPass)
        TextView tvPass;
        @BindView(R.id.tvDate)
        TextView tvDate;

        ExchangeVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        void bind(ExchangeModel exchangeModel) {
            tvNum.setText(exchangeModel.getNumber());
            tvName.setText(exchangeModel.getName());
            tvDescription.setText(exchangeModel.getDescription());
            tvDate.setText(exchangeModel.getDate());
            if (exchangeModel.isPassed()) {
                imgPass.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_check_circle_black_24dp));
                tvPass.setText(R.string.exchangePassed);
            } else {
                imgPass.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_cancel_black_24dp));
                tvPass.setText(R.string.exchangeCanceled);
            }

            if (exchangeModel.getType() == 0) {
                imgType.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_confirmation_number_24dp));
            } else if (exchangeModel.getType() == 1) {
                imgType.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_verified_user_24dp));
            } else if (exchangeModel.getType() == 2) {
                imgType.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_work_24dp));
            } else {
                imgType.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_flight_24dp));
            }
        }
    }
}
