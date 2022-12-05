package com.if3b.aplikasiaku.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.if3b.aplikasiaku.API.APIRequestData;
import com.if3b.aplikasiaku.API.RetroServer;
import com.if3b.aplikasiaku.Adapter.AdapterQuote;
import com.if3b.aplikasiaku.Model.QuotesModel;
import com.if3b.aplikasiaku.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvQuotes;
    private ProgressBar pbQuotes;
    private List<QuotesModel> listQuotes;
    private AdapterQuote adQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvQuotes = findViewById(R.id.rv_quotes);
        pbQuotes = findViewById(R.id.pb_quotes);
        rvQuotes.setLayoutManager(new LinearLayoutManager(this));
        retrieveQuote();


    }

    private void retrieveQuote(){
    pbQuotes.setVisibility(View.VISIBLE);

        APIRequestData ARD = RetroServer.connectRetrofit().create(APIRequestData.class);
        Call<List<QuotesModel>> retrieverProcess = ARD.requestData();

        retrieverProcess.enqueue(new Callback<List<QuotesModel>>() {
            @Override
            public void onResponse(Call<List<QuotesModel>> call, Response<List<QuotesModel>> response) {
                listQuotes = response.body();
                adQuotes = new AdapterQuote(listQuotes,MainActivity.this);
                rvQuotes.setAdapter(adQuotes);
            }

            @Override
            public void onFailure(Call<List<QuotesModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed To Reach Server", Toast.LENGTH_SHORT).show();
                pbQuotes.setVisibility(View.VISIBLE);
            }
        });
    }
}