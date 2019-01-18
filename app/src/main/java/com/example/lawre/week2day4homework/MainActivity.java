package com.example.lawre.week2day4homework;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserInput.OnFragmentInteractionListener
{
    public static final String TAG = "MAIN_ACT ";
    ArrayList<User> userList;
    DisplayUsers displayUsers;
    UserInput userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userList = new ArrayList<>();
        userList.add(new User("John Egbert","ectobiologist","ghostytrickster"));
        displayUsers = new DisplayUsers();
        Log.d(TAG, "onCreate: " + displayUsers);
        //displayUsers.setUsers(userList);
        userInput = new UserInput();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frInputFrag,userInput).commit();
        fm.beginTransaction().replace(R.id.frDisplayFrag,displayUsers).commit();
    }

    @Override
    public void sendToActivity(User u)
    {
        //userList.add(u);
        displayUsers.addUser(u);
    }


}
