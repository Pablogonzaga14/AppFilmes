package com.example.appfilmes;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfilmes.Adapter.AdapterFilme;
import com.example.appfilmes.Model.Filme;
import com.example.appfilmes.Model.FilmeApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView_filmes;
    private AdapterFilme adapterFilme;
    private List <Filme> filmeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        IniciarComponestes();
        filmeList = new ArrayList<>();


// Configurar retrofit

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://firebasestorage.googleapis.com/v0/b/app-tia.firebasestorage.app/o/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        // Iniciar a retrofit
        FilmeApi filmeApi = retrofit.create(FilmeApi.class);
        Call<List<Filme>> call = filmeApi.getFilmes();
        call.enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                if (response.code() != 200){
                    return;
                }
                List<Filme> filmes = response.body();

                for (Filme filme : filmes){
                    filmeList.add(filme);
                }
                adapterFilme = new AdapterFilme(getApplicationContext(),filmeList);
                recyclerView_filmes.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                recyclerView_filmes.setHasFixedSize(true);
                recyclerView_filmes.setAdapter(adapterFilme);
            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {

            }
        });
    }
    public  void IniciarComponestes(){
        recyclerView_filmes = findViewById(R.id.recyclerView_filmes);
    }
}