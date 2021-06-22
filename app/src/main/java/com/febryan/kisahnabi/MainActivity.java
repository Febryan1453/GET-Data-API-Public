package com.febryan.kisahnabi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.febryan.kisahnabi.api.ApiConfig;
import com.febryan.kisahnabi.model.ResponseKisahNabi;
import com.febryan.kisahnabi.model.ResultItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvKisah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKisah = findViewById(R.id.rv_kisah_nabi);
        rvKisah.setHasFixedSize(true);
        rvKisah.setLayoutManager(new GridLayoutManager(this,2));

        ApiConfig.service.getListKisahNabi().enqueue(new Callback<ResponseKisahNabi>() {
            @Override
            public void onResponse(Call<ResponseKisahNabi> call, Response<ResponseKisahNabi> response) {
                if (response.isSuccessful()){
                    ResponseKisahNabi responseKisahNabi = response.body();
                    List<ResultItem> resultItems = responseKisahNabi.getResult();
                    KisahNabiAdapter kisahNabiAdapter = new KisahNabiAdapter(resultItems);
                    kisahNabiAdapter.notifyDataSetChanged();
                    rvKisah.setAdapter(kisahNabiAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseKisahNabi> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Call Layout Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_kisah_nabi, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_list){
            rvKisah.setLayoutManager(new LinearLayoutManager(this));
        }
        if (item.getItemId() == R.id.action_grid){
            rvKisah.setLayoutManager(new GridLayoutManager(this, 2));
        }

        return super.onOptionsItemSelected(item);
    }

}