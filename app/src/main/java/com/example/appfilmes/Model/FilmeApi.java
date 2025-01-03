package com.example.appfilmes.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmeApi {

    @GET("filmes.json?alt=media&token=154476fa-f504-4167-b74d-bc2945fddb7f")
    Call<List<Filme>> getFilmes();

}
