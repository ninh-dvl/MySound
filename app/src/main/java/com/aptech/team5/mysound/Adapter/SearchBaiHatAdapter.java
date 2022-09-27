package com.aptech.team5.mysound.Adapter;


import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.aptech.team5.mysound.R;
import com.aptech.team5.mysound.Service.APIService;
import com.aptech.team5.mysound.Service.DataService;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Response;

public class SearchBaiHatAdapter extends RecyclerView.Adapter<SearchBaiHatAdapter.ViewHolder>{
    Context context;
    ArrayList<Baihat> = mangbaihat;

    public SearchBaiHatAdapter(Context context, ArrayLis<Baihat> mangbaihat){
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @Override
    public ViewHolder onCreViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_search_bai_hat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Baihat baihat = mangbaihat.get(position);
        holder.txtTenbaihat.setText(baihat.getTenbaihat());
        holder.txtCasi.setText(baihat.getCasi());
        Picasso.with(context).load(baihat.getLinkbaihat()).into(holder.imgbaihat);
    }

    @Override
    public int getItemCount(){
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenbaihat,txtCasi;
        ImageView imgbaihat,imgluotthich;
        public ViewHolder(View itemView){
            super(itemView);
            txtTenbaihat = itemView.findViewById(R.id.textviewsearchtenbaihat);
            txtCasi = itemView.findViewById(R.id.textviewsearchcasi);
            imgbaihat = itemView.findViewById(R.id.imagesearchbaihat);
            imgluotthich = itemView.findViewById(R.id.imagesearchluotthich);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc",mangbaihat.get(getPosition()));
                }
            });
            imgluotthich.setOnClickListener(new View.OnClickListener(){
                @Override
                public void OnClick(View v){
                    imgluotthich.setImageResource(R.drawable.heartfull);
                    DataService dataservice = APIService.getService();
                    Call<String> callback = dataservice.UpdateLuotThich("1",mangbaihat.get(getPosition()).getIdbaihat());
                    callback.enqueue(new Callback<String>(){
                       @Override
                       public void onResponse(Call<String> call, Response<String> response){
                           String ketqua = response.body();
                           if (ketqua.equals("success")){
                               Toast.makeText(context,"Da thich",Toast.LENGTH_SHORT).show();
                           }else{
                               Toast.makeText(context, "Loi!",Toast.LENGTH_SHORT).show();
                           }
                       }
                       @Override
                        public void onFailure(Call<String> call, Throwable t){

                       }
                    });
                    imgluotthich.setEnabled(false);
                }
            });
        }
    }
}
