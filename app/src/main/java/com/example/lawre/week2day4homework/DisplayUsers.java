package com.example.lawre.week2day4homework;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DisplayUsers extends Fragment
{
    public static final String TAG = "DISPLAY_USERS";
    RecyclerView recyclerView;
    RecyclerViewAdapter rvAdapter;
    ArrayList<User> allUsers;

    public DisplayUsers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        allUsers = new ArrayList<>();
        allUsers.add(new User("John Egbert","ectobiologist","ghostytrickster"));
        recyclerView = view.findViewById(R.id.rvRecycler);
        rvAdapter = new RecyclerViewAdapter(allUsers);
        RecyclerView.LayoutManager layoutMan = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutMan);
        recyclerView.setAdapter(rvAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public void setUsers(ArrayList<User> theUsers)
    {
        allUsers = theUsers;
    }

    public void addUser(User u)
    {
        rvAdapter.addUser(u);
    }
}
