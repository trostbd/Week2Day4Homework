package com.example.lawre.week2day4homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    public static final String TAG = "R_V_A";
    ArrayList<User> userList;

    public RecyclerViewAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position)
    {
        User newUser = userList.get(position);

        if(newUser != null)
        {
            String name = newUser.getName();
            String email = newUser.getEmail();
            String password = newUser.getPassword();
            viewHolder.setItemUser(newUser);
            viewHolder.tvName.setText(name);
            viewHolder.tvEmail.setText(email);
            viewHolder.tvPassword.setText(password);
        }


    }

    @Override
    public int getItemCount() {
        return userList != null ? userList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName, tvEmail, tvPassword;
        User itemUser;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvUserName);
            tvEmail = itemView.findViewById(R.id.tvUserEmail);
            tvPassword = itemView.findViewById(R.id.tvUserPassword);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: ");
                    LengthTask leng = new LengthTask(v, new User(tvName.getText().toString(),tvEmail.getText().toString(),tvPassword.getText().toString()));
                    leng.execute();
                }
            });
        }

        public User getItemUser() {
            return itemUser;
        }

        public void setItemUser(User itemUser) {
            this.itemUser = itemUser;
        }
    }

    public void addUser(User mu)
    {
        userList.add(mu);
        notifyDataSetChanged();;
    }
}

