package com.example.appfilmes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class DetalhesFilme extends AppCompatActivity {
    private ImageView dtCapaFilme,playVideo;
    private TextView dtTituloFilme,dtDescricaoFilme,dtElencoFilme;
    private Toolbar toolbarDetalhes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        InciarComponentes();
        String capa = getIntent().getStringExtra("capa");
        String titulo = getIntent().getStringExtra("titulo");
        String descricao = getIntent().getStringExtra("descricao");
        String elenco = getIntent().getStringExtra("elenco");

        Glide.with(getApplicationContext()).load(capa).into(dtCapaFilme);
        dtTituloFilme.setText(titulo);
        dtDescricaoFilme.setText(descricao);
        dtElencoFilme.setText(elenco);

        //Configurar toolbar
        toolbarDetalhes.setNavigationOnClickListener(view -> finish());
    }

    public void InciarComponentes(){
        dtCapaFilme = findViewById(R.id.dtCapaFilme);
        playVideo = findViewById(R.id.playVideo);
        dtTituloFilme = findViewById(R.id.dtTituloFilme);
        dtDescricaoFilme = findViewById(R.id.dtDescricaoFilme);
        dtElencoFilme = findViewById(R.id.dtElencoFilme);
        toolbarDetalhes = findViewById(R.id.toolbarDetalhes);
    }
}