package com.example.skripsi2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Contact> contacts;
    private Context context;

    public Adapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.user.setText(contacts.get(position).getUser());
        holder.pesan.setText(contacts.get(position).getPesan());
        holder.pa.setText(contacts.get(position).getPa());
//        String pam = pa.getText().toString();
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView user,pesan, pa;
        public MyViewHolder(View itemView) {
            super(itemView);
            pa = itemView.findViewById(R.id.pa);

            user = itemView.findViewById(R.id.user);
            pesan = itemView.findViewById(R.id.pesan);
        }
    }
}