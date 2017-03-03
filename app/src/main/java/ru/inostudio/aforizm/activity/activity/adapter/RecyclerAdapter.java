package ru.inostudio.aforizm.activity.activity.adapter;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ru.inostudio.aforizm.R;
import ru.inostudio.aforizm.activity.activity.activities.Aphorism;


/**
 * Created by Admin on 21.10.2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        // наш пункт состоит только из одного TextView
        public TextView AforizmView;

        public ViewHolder(View v) {
            super(v);
            AforizmView = (TextView) v.findViewById(R.id.recycler_item);
        }
    }

    // Конструктор
    public RecyclerAdapter(String[] aforizm) {

        mDataset = aforizm;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_aforizm, parent, false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.AforizmView.setText(mDataset[position]);
        holder.AforizmView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Aphorism.class);
                intent.putExtra(Aphorism.AFORIZM,mDataset[position]);
                v.getContext().startActivity(intent);
            }
        });
    }

    // Возвращает размер данных (вызывается layout manager-ом)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}