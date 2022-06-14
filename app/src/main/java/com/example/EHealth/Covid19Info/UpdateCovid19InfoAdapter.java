package com.example.EHealth.Covid19Info;

import android.content.Context;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.EHealth.R;

import java.util.ArrayList;

import Model.Covid19InfoModel;

public class UpdateCovid19InfoAdapter extends RecyclerView.Adapter<UpdateCovid19InfoAdapter.ViewHolder> {

    private ArrayList<Covid19InfoModel> covid19InfoModelArrayList;
    private Context context;

    // constructor
    UpdateCovid19InfoAdapter(ArrayList<Covid19InfoModel> covid19InfoModelArrayList, Context context) {
        this.covid19InfoModelArrayList = covid19InfoModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler layouts items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcview_covid19_info, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Covid19InfoModel model = covid19InfoModelArrayList.get(position);
        // display covid info
        holder.title_txt.setText(model.getCovid19InfoTitle());
        holder.date_txt.setText(model.getCovid19InfoDate());
        holder.content_txt.setText(model.getCovid19InfoContent());

        // make rc layouts clickable and user can edit covid title and content
        holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // on below line we are calling an intent.
            Intent i = new Intent(context, UpdateCovid19InfoPage.class);

            // below we are passing all our values.
            i.putExtra("id", model.getId());
            i.putExtra("title", model.getCovid19InfoTitle());
            i.putExtra("content", model.getCovid19InfoContent());

            // starting our activity.
            context.startActivity(i);
        }
    });
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
