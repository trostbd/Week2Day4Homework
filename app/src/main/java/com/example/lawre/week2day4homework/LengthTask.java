package com.example.lawre.week2day4homework;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;


public class LengthTask extends AsyncTask<String,String,String>
{

    User myUsser;
    View v;

    public LengthTask(View v, User u)
    {
        myUsser = u;
        this.v = v;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s)
    {
        Toast.makeText(v.getContext(),"Length is " + myUsser.name.length(),Toast.LENGTH_SHORT).show();
        super.onPostExecute(s);
    }
}
