package com.febryan.kisahnabi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.febryan.kisahnabi.model.ResultItem;

import java.util.List;

public class KisahNabiAdapter extends RecyclerView.Adapter<KisahNabiAdapter.MyViewHolder> {

    private List<ResultItem> resultItems;
    public KisahNabiAdapter(List<ResultItem> resultItems){
        this.resultItems = resultItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_kisah_nabi, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTanggal.setText(resultItems.get(position).getThnKelahiran());
        holder.tvPenulis.setText(resultItems.get(position).getTmp());
        holder.tvJudul.setText(resultItems.get(position).getName());

        Glide.with(holder.itemView)
                .load(resultItems.get(position).getImageUrl())
                .into(holder.imageView);

        Context context = holder.itemView.getContext();
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailKisahNabiActivity.class);
            intent.putExtra("DETAIL", resultItems.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return resultItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvJudul, tvPenulis, tvTanggal;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image_nabi);
            tvJudul = itemView.findViewById(R.id.item_tv_nama_nabi);
            tvPenulis = itemView.findViewById(R.id.item_tv_tmp);
            tvTanggal = itemView.findViewById(R.id.item_tv_tahun_lahir);
        }
    }
}
