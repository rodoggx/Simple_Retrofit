package com.example.simpleretrofit;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.simpleretrofit.network.MyAdapter;
import com.example.simpleretrofit.network.RetrofitMagic;

public class MainActivity extends AppCompatActivity {

    //instance variables
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;

    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Strict mode policy - allow all to run on main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        mMyAdapter = new MyAdapter(RetrofitMagic.getStudents(), this);

        //create new class that contains recycler view custom adaptor

        mRecyclerView = (RecyclerView) findViewById(R.id.mRecycler);
        mRecyclerView.setAdapter(mMyAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
