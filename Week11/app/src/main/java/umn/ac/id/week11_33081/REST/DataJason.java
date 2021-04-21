package umn.ac.id.week11_33081.REST;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import umn.ac.id.week11_33081.Model.Data;

public interface DataJason {

    @GET("posts")
    Call<ArrayList<Data>> getPosts();
}
