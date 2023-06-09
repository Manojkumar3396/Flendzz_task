package com.example.emp_activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyHolder> {

            Context context;
      ArrayList<LinearPojo> arrayList;
              public AdapterRecycler(Context context, ArrayList<LinearPojo> arrayList){
                  this.context = context;
                  this.arrayList = arrayList;
              }

               @NonNull
       @Override
       public AdapterRecycler.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                   View view = LayoutInflater.from(context).inflate(R.layout.emp_layout, parent, false);
                   MyHolder myHolder = new MyHolder(view);
                  return myHolder;
              }

             @Override
     public void onBindViewHolder(@NonNull AdapterRecycler.MyHolder holder, @SuppressLint("RecyclerView") int position) {

                 holder.e_name.setText(arrayList.get(position).getName());
                  holder.e_email.setText(arrayList.get(position).getEmail());

                 holder.itemView.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Context context = view.getContext();
                         Intent i = new Intent(context, Emp_detailActivity.class);
                         i.putExtra("id" ,arrayList.get(position).getId());
                         i.putExtra("name" ,arrayList.get(position).getName());
                         i.putExtra("email" ,arrayList.get(position).getEmail());
                         i.putExtra("suite" ,arrayList.get(position).getSuite());
                         i.putExtra("street" ,arrayList.get(position).getStreet());
                         i.putExtra("city" ,arrayList.get(position).getCity());
                         i.putExtra("code" ,arrayList.get(position).getZipcode());
                         i.putExtra("names" ,arrayList.get(position).getC_name());
                         i.putExtra("bs" ,arrayList.get(position).getBs());
                         context.startActivity(i);

                     }
                 });



             }

             @Override
       public int getItemCount() {
                  return arrayList.size();
              }

              public static class MyHolder extends RecyclerView.ViewHolder{
          TextView e_name, e_email;
          public MyHolder(@NonNull View view){
                         super(view);
              e_name = view.findViewById(R.id.e_name);
              e_email = view.findViewById(R.id.e_email);
                       }
       }

           }