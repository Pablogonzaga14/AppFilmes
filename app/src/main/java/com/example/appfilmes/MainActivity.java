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

import java.util.ArrayList;
import java.util.List;

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
        adapterFilme = new AdapterFilme(getApplicationContext(),filmeList);
        recyclerView_filmes.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView_filmes.setHasFixedSize(true);
        recyclerView_filmes.setAdapter(adapterFilme);

        Filme filme1 = new Filme(R.drawable.ic_launcher_background,"teste");
        filmeList.add(filme1);
        Filme filme2 = new Filme(R.drawable.ic_launcher_background,"teste");
        filmeList.add(filme2);
        Filme filme3 = new Filme(R.drawable.ic_launcher_background,"teste");
        filmeList.add(filme3);
        Filme filme4 = new Filme(R.drawable.ic_launcher_background,"teste");
        filmeList.add(filme4);
        Filme filme5 = new Filme(R.drawable.ic_launcher_background,"teste");
        filmeList.add(filme5);
        Filme filme6 = new Filme(R.drawable.ic_launcher_background,"teste");
        filmeList.add(filme6);
        Filme filme7 = new Filme(R.drawable.ic_launcher_background,"teste");
        filmeList.add(filme7);
        Filme filme8 = new Filme(R.drawable.ic_launcher_background,"teste");
        filmeList.add(filme8);
    }
    public  void IniciarComponestes(){
        recyclerView_filmes = findViewById(R.id.recyclerView_filmes);
    }
}