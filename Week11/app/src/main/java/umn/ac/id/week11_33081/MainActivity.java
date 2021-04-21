package umn.ac.id.week11_33081;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import umn.ac.id.week11_33081.Adapter.DataAdapter;
import umn.ac.id.week11_33081.Model.Data;
import umn.ac.id.week11_33081.REST.ApiClient;
import umn.ac.id.week11_33081.REST.DataJason;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvData;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DataJason mDataJason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.rvData);
        mLayoutManager = new LinearLayoutManager(this);
        rvData.setLayoutManager(mLayoutManager);

        mDataJason = ApiClient.getClient().create(DataJason.class);

        getD();
    }

    private void getD() {
        Call<ArrayList<Data>> mData = mDataJason.getPosts();
        mData.enqueue(new Callback<ArrayList<Data>>() {
            @Override
            public void onResponse(Call<ArrayList<Data>> call, Response<ArrayList<Data>> response) {
            ArrayList<Data> allData = response.body();

            mAdapter = new DataAdapter(allData);
            rvData.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}