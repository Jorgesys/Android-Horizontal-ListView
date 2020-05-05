package com.jorgesys.recyclerviewHorizontal;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private List<Person> data;
    private RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public MyRecyclerViewAdapter(@NonNull List<Person> data,
                                 @NonNull RecyclerViewOnItemClickListener
                                      recyclerViewOnItemClickListener) {
        this.data = data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Person person = data.get(position);
        holder.getNameTextView().setText(person.getName());
        holder.getAgeTextView().setText(String.valueOf(person.getAge()));
        //set image with picasso.
        //permission required : android.permission.INTERNET
        Picasso.get()
                .load(person.getUrlImage())
                .into(holder.getPersonImageView());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View
        .OnClickListener {
        private TextView nameTextView;
        private TextView ageTextView;
        private ImageView personImageView;


        public MyViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            ageTextView = (TextView) itemView.findViewById(R.id.ageTextView);
            personImageView = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        public TextView getNameTextView() {
            return nameTextView;
        }

        public TextView getAgeTextView() {
            return ageTextView;
        }

        public ImageView getPersonImageView() {
            return personImageView;
        }


        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v, getAdapterPosition());
        }
    }

}

