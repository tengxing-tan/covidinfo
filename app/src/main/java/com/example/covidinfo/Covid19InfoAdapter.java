package com.example.covidinfo;

import android.content.Context;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Model.Covid19InfoModel;

public class Covid19InfoAdapter extends RecyclerView.Adapter<Covid19InfoAdapter.ViewHolder> {

    private ArrayList<Covid19InfoModel> covid19InfoModelArrayList;
    private Context context;

    // constructor
    Covid19InfoAdapter(ArrayList<Covid19InfoModel> covid19InfoModelArrayList, Context context) {
        this.covid19InfoModelArrayList = covid19InfoModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcview_covid19_info, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Covid19InfoModel model = covid19InfoModelArrayList.get(position);
        holder.title_txt.setText(model.getCovid19InfoTitle());
        holder.date_txt.setText(model.getCovid19InfoDate());
        holder.content_txt.setText(model.getCovid19InfoContent());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return covid19InfoModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title_txt, date_txt, content_txt;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            title_txt = itemView.findViewById(R.id.title_txt);
            date_txt = itemView.findViewById(R.id.date_txt);
            content_txt = itemView.findViewById(R.id.content_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

}
