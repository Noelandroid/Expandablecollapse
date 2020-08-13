package com.example.expandablecollapse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final String URL_GET_DATA = "https://howtodoandroid.com/movielist.json";

    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        movieList = new ArrayList<>();

        //loadLatest();
        loadFavourite();
        //loadHighlyRated();



    }

    private void loadFavourite() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GET_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);

                              /*  Movie movie = new Movie(
                                        obj.getString("category"),
                                        obj.getString("imageUrl"),
                                        obj.getString("name")
                                );*/
                                 String category=obj.getString("category");
                                String imageurl=obj.getString("imageUrl");
                                String name=obj.getString("name");

                                System.out.println("imageurl:::"+imageurl);

                                System.out.println("Category::"+category);

                                System.out.println("Name::"+name);

                              movieList.add(new Movie(category,imageurl,name));
                            }


                            MovieAdapter secondAdapter = new MovieAdapter(movieList, MainActivity.this);
                            MultiSnapRecyclerView secondRecyclerView = (MultiSnapRecyclerView) findViewById(R.id.secondrecyclerView);
                            LinearLayoutManager secondManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                            secondRecyclerView.setLayoutManager(secondManager);
                            secondRecyclerView.setAdapter(secondAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

   /* private void loadLatest() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GET_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);

                                Movie movie = new Movie(
                                        obj.getString("category"),
                                        obj.getString("imageUrl"),
                                        obj.getString("name")
                                );

                                movieList.add(movie);
                            }


                            MovieAdapter firstAdapter = new MovieAdapter(getApplicationContext(), movieList);
                            MultiSnapRecyclerView firstRecyclerView = (MultiSnapRecyclerView) findViewById(R.id.firstrecyclerView);
                            LinearLayoutManager firstManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                            firstRecyclerView.setLayoutManager(firstManager);
                            firstRecyclerView.setAdapter(firstAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }



    private void loadHighlyRated() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GET_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);

                                Movie movie = new Movie(
                                        obj.getString("category"),
                                        obj.getString("imageUrl"),
                                        obj.getString("name")
                                );

                                movieList.add(movie);
                            }


                            MovieAdapter thirdAdapter = new MovieAdapter(getApplicationContext(), movieList);
                            MultiSnapRecyclerView thirdRecyclerView = (MultiSnapRecyclerView) findViewById(R.id.thirdrecyclerView);
                            LinearLayoutManager thirdManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                            thirdRecyclerView.setLayoutManager(thirdManager);
                            thirdRecyclerView.setAdapter(thirdAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }*/
    }






