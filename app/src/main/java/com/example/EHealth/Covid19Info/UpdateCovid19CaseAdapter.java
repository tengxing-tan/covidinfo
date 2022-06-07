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

import Model.Covid19CaseModel;

public class UpdateCovid19CaseAdapter extends RecyclerView.Adapter<UpdateCovid19CaseAdapter.ViewHolder> {
     private ArrayList<Covid19CaseModel> covid19CaseModelArrayList;
    private Context context;

    // constructor
    public UpdateCovid19CaseAdapter(ArrayList<Covid19CaseModel> covid19CaseModelArrayList, Context context) {
        this.covid19CaseModelArrayList = covid19CaseModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcviewe_covid19_case, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Covid19CaseModel model = covid19CaseModelArrayList.get(position);
        // display covid info
        holder.ic_number_txt.setText(model.getPatientID());
        holder.date_txt.setText(model.getActiveDate());
        holder.case_type_txt.setText(model.getCaseType());
        holder.is_active_txt.setText((model.getIsActive() != 0) ? "(active)" : "(inactive)");

        // make rc view clickable and user can edit covid title and content
        holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // on below line we are calling an intent.
            Intent i = new Intent(context, UpdateExistingCasePage.class);

            // below we are passing all our values.
            i.putExtra("id", model.getId());
            i.putExtra("patientID", model.getPatientID());
            i.putExtra("activeDate", model.getActiveDate());
            i.putExtra("caseType", model.getCaseType());

            // starting our activity.
            context.startActivity(i);
        }
    });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return covid19CaseModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView ic_number_txt, date_txt, case_type_txt, is_active_txt;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            ic_number_txt = itemView.findViewById(R.id.ic_number_txt);
            date_txt = itemView.findViewById(R.id.date_txt);
            case_type_txt = itemView.findViewById(R.id.case_type_txt);
            is_active_txt = itemView.findViewById(R.id.is_active_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

}
